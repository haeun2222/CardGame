package com.comeon.cardgame.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.comeon.cardgame.tool.CardOne;
import com.comeon.cardgame.tool.Player;

public abstract class CompareImpl implements ICompare {

	List<Player> players;
	CardOne[] currentCards;
	Player[] ranking;
	
	List<CardOne> validValue;
	Set<Integer> changeIdx;
	Map<Player, Integer> score;

	String[] nowPShape;
	String[] nowPNumber;
	
	protected CompareImpl() {
		players = Game.room.getPlayers();
		ranking  = new Player[players.size()];
		changeIdx = new HashSet<Integer>();
		nowPShape = new String[CARDNUM];
		nowPNumber = new String[CARDNUM];
	}
	
	@Override
	public void makeJokboAndChange() {
		for (Player player : players) {
			if(player.getIsDie()) continue;
			clear();
			CardOne[] after = bubbleSort(player.getMyCard());
			player.setMyCard(after);
			currentCards = player.getMyCard().clone();
			separateCard();
			findValidValue();
			String jokbo = makeJokboName();
			player.setJokbo(jokbo);
			player.setChangeIdx(new ArrayList<Integer>(changeIdx));
		}
	}
	
	protected void clear() {
		if(validValue != null) {
			validValue.clear();
		}
		if(changeIdx != null) {
			changeIdx.clear();
		}
		if(score != null) {
			score.clear();
		}
	}
	
	protected CardOne[] bubbleSort(CardOne[] before) {
		CardOne[] after = before.clone();
		int len = after.length;
		CardOne temp;
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1; j++) {
				if (after[j].getSize() > after[j + 1].getSize()) {
					temp = after[j];
					after[j] = after[j + 1];
					after[j + 1] = temp;
				}
			}
		}
		
		return after;
	}
	
	// low랑 high랑 같음
	protected void separateCard() {
		for (int i = 0; i < currentCards.length; i++) {
			nowPShape[i] = currentCards[i].getOne().substring(0, 1);
			nowPNumber[i] = currentCards[i].getOne().substring(1);
		}
	}
	
	// low랑 high랑 같음
	protected void findValidValue() {
		validValue = new ArrayList<CardOne>(List.of(currentCards.clone()));
		int len = currentCards.length;
		
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				isValid(i, j);
			}
		}
	}
	
	protected abstract void isValid(int targetIdx, int compareIdx);
	
	@Override
	public void comparePlayers() {
		saveScore();
		for (int i = 0; i < ranking.length; i++) {
			ranking[i] = players.get(i);
		}
		bubbleSortRanking();
		if(ranking[0].getIsCom()) {
			Game.room.setIsUserLose(true);
		}
	}

	// high랑 reverse랑 동일
	protected void bubbleSortRanking() {
		Player temp;
		for (int i = 0; i < ranking.length; i++) {
			for (int j = 0; j < ranking.length - 1; j++) {
				if (score.get(ranking[j]) < score.get(ranking[j+1])) {
					temp = ranking[j];
					ranking[j] = ranking[j +1];
					ranking[j+1] = temp;
				}
			}
		}
		Game.room.setRanking(ranking);
	}

	protected void saveScore() {
		score = new HashMap<>();
		for (Player player : players) {
			score.put(player, calScore(player));
		}
	}
	
	protected int calScore(Player player) {
		String jokbo = player.getJokbo();
		int idx = jokbo.indexOf("\u0020");
		return compareJokboName(jokbo.substring(0,idx))+compareJokboTop(jokbo.substring(idx+1));
	}
	
	// high랑 reverse랑 동일
	protected int compareJokboName(String jokboName) {
		int score = switch (jokboName) {
		case "메이드" ->60;
		case "베이스" ->40;
		case "투베이스" ->20;
		default ->0;
		};
		return score;
	}
	
	// high랑 reverse랑 동일
	protected int compareJokboTop(String jokboTop) {
		int score = switch (jokboTop) {
		case "퍼펙트"->9;
		case "골프" ->8;
		case "세컨드" ->7;
		case "써드" -> 6;
		default ->compareJokboTopNumber(jokboTop.substring(1));
		};

		return score;
	}

	protected int compareJokboTopNumber(String jokboTopNumber) {
		int score = 0;
		for (int i = 0; i < CardOne.number.length; i++) {
			if(jokboTopNumber.equals(CardOne.number[i])) {
				score = i;
			}
		}
		return score;
	}

	protected String makeJokboName() {
		String jokbo = switch (validValue.size()) {
		case 4 ->"메이드\u0020"+madeName();
		case 3->"베이스\u0020봇"+makeJokboNumber();		
		case 2->"투베이스\u0020봇"+makeJokboNumber();
		default->"논\u0020봇"+makeJokboNumber();
		};
		return jokbo;
	}
	
	protected abstract String madeName();
	
	// high랑 reverse랑 동일
	protected String makeJokboNumber() {
		if(!validValue.isEmpty()) {
			return validValue.get(0).getOne().substring(1);
		} else {			
			return "";
		}
	}


}
