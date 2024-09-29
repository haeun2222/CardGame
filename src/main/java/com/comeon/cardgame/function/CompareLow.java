package com.comeon.cardgame.function;

import java.util.Arrays;
import com.comeon.cardgame.tool.Player;

public class CompareLow extends CompareImpl{
	
	private static CompareLow compareLow;
	
	private CompareLow() {};
	
	public static CompareLow getInstance() {
		if(compareLow == null) {
			compareLow = new CompareLow();
		}
		return compareLow;
	}
	
	@Override
	protected void isValid(int targetIdx, int compareIdx) {		
		if( nowPShape[targetIdx].equals(nowPShape[compareIdx]) ||
				nowPNumber[targetIdx].equals(nowPNumber[compareIdx])) {
			validValue.remove(currentCards[compareIdx]);
			changeIdx.add(compareIdx);
		}
	}

	@Override
	protected void bubbleSortRanking() {
		Player temp;
		for (int i = 0; i < ranking.length; i++) {
			for (int j = 0; j < ranking.length - 1; j++) {
				if (score.get(ranking[j]) > score.get(ranking[j+1])) {
					temp = ranking[j];
					ranking[j] = ranking[j +1];
					ranking[j+1] = temp;
				}
			}
		}
		Game.room.setRanking(ranking);
	}

	@Override
	protected int compareJokboName(String jokboName) {
		int score = switch (jokboName) {
		case "메이드" ->0;
		case "베이스" ->20;
		case "투베이스" ->40;
		default ->60;
		};
		return score;
	}

	@Override
	protected int compareJokboTop(String jokboTop) {
		int score = switch (jokboTop) {
		case "골프" ->0;
		case "세컨드" ->1;
		case "써드" -> 2;
		default ->compareJokboTopNumber(jokboTop.substring(1));
		};

		return score;
	}
	
	@Override
	protected String makeJokboName() {
		String jokbo = switch (validValue.size()) {
		case 1 ->"논\u0020탑"+makeJokboNumber();
		case 2->"투베이스\u0020탑"+makeJokboNumber();
		case 3->"베이스\u0020탑"+makeJokboNumber();		
		default ->"메이드\u0020"+madeName();
		};
		return jokbo;
	}
	
	@Override
	protected String madeName() {	
		if(Arrays.equals(nowPNumber, new String[] {"A","2","3","4"})) {
			return "골프";
		} else if (Arrays.equals(nowPNumber, new String[] {"A","2","3","5"})){
			return "세컨드";
		} else if (Arrays.equals(nowPNumber, new String[] {"A","2","4","5"})){
			return "써드";
		} else {
			return "탑"+makeJokboNumber();
		}
	}
	
	@Override
	protected String makeJokboNumber() {
		return validValue.get(validValue.size()-1).getOne().substring(1);
	}
}
