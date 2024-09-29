package com.comeon.cardgame.function;

import java.util.Arrays;

public class CompareHigh extends CompareImpl {
	
	private static CompareHigh compareHigh;
	
	private CompareHigh() {};
	
	public static CompareHigh getInstance() {
		if(compareHigh == null) {
			compareHigh = new CompareHigh();
		}
		return compareHigh;
	}

	@Override
	protected void isValid(int targetIdx, int compareIdx) {		
		if( nowPShape[targetIdx].equals(nowPShape[compareIdx]) ||
				nowPNumber[targetIdx].equals(nowPNumber[compareIdx])) {
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
		} else {
			return "봇"+makeJokboNumber();
		}
	}

}
