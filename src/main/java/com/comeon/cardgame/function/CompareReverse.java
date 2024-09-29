package com.comeon.cardgame.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comeon.cardgame.tool.CardOne;

public class CompareReverse extends CompareImpl {
	
	private static CompareReverse compareReverse;
	private Map<String, Integer> shapeCnt;
	private String validShape;
	
	private CompareReverse() {};
	
	public static CompareReverse getInstance() {
		if(compareReverse == null) {
			compareReverse = new CompareReverse();
		}
		return compareReverse;
	}

	@Override
	protected void separateCard() {
		for (int i = 0; i < currentCards.length; i++) {
			nowPShape[i] = currentCards[i].getOne().substring(0, 1);
			nowPNumber[i] = currentCards[i].getOne().substring(1);
		}
		countShape();
		findValidShape();
	}
	
	@Override
	protected void findValidValue() {
		validValue = new ArrayList<CardOne>(List.of(currentCards.clone()));
		int len = currentCards.length;
		
		if(!sameNumber()) {
			for (int i = 0; i < len; i++) {
				isValid(i, i+1);
			}
		}		
	}
	
	@Override
	protected void isValid(int targetIdx, int compareIdx) {	
		if( !nowPShape[targetIdx].equals(validShape) ) {
			validValue.remove(currentCards[targetIdx]);
			changeIdx.add(targetIdx);
		}
	}
	
	@Override
	protected String madeName() {
		if(Arrays.equals(nowPNumber, new String[] {"10","J","Q","K"})) {
			return "골프";
		} else if (Arrays.equals(nowPNumber, new String[] {"9","J","Q","K"})){
			return "세컨드";
		} else if (Arrays.equals(nowPNumber, new String[] {"9","10","Q","K"})){
			return "써드";
		} else if(sameNumber()) {
			return "퍼펙트";
		} else {
			return "봇"+makeJokboNumber();
		}
	}
	
	@SuppressWarnings("serial")
	private void countShape() {
		shapeCnt = new HashMap<String, Integer>(){{
			put("♣",0);
			put("♥",0);
			put("◆",0);
			put("♠",0);			
		}};
		for (int i = 0; i < nowPShape.length; i++) {
			shapeCnt.put(nowPShape[i], (shapeCnt.get(nowPShape[i])+1));
		}
	}

	private void findValidShape() {
		if(!shapeCnt.containsValue(2) && !shapeCnt.containsValue(3) && !shapeCnt.containsValue(4)) {
			validShape = nowPShape[3];
		} else {
			for (int i = 0; i < nowPShape.length; i++) {
				if(shapeCnt.get(nowPShape[i]) == ICompare.CARDNUM 
						|| shapeCnt.get(nowPShape[i]) == 3) {
					validShape = nowPShape[i];
					break;
				} else if(shapeCnt.get(nowPShape[i]) == 2) {
					validShape = nowPShape[i];				
				}
			}
		}
	}
	
	private boolean sameNumber() {
		int cnt = 0;
		for (int i = 0; i < nowPNumber.length; i++) {
			if(nowPNumber[0].equals(nowPNumber[i])) {
				cnt++;
			}
		}
		return (cnt==4)?true:false;
	}
}
