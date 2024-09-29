package com.comeon.cardgame.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.comeon.cardgame.tool.CardOne;
import com.comeon.cardgame.tool.Player;

public class Change {

	private static Change change;
	private List<CardOne> cardCase;
	private Set<CardOne> cardCasePost;
	private List<Player> players;
	private int turn;
	private static int cutCnt;

	private Change() {
		cardCasePost = new HashSet<CardOne>();
	}
	
	public static Change getInstance() {
		if(change==null) {
			change = new Change();
		}
		return change;
	}
	
	public void devideOrCut() {
		clear();
		if(cutCnt==0) {
			allDevide();
		}
		else allCut();
		cutCnt++;
		if(cutCnt==4) {
			cutCnt=0;
		}
	}
	
	private void clear() {
		cardCase = Game.room.getCards();
		players = Game.room.getPlayers();
		turn = Game.room.getBoss();
	}

	private void allDevide() {
		for (int i = 0; i < players.size(); i++) {
			oneDevide(players.get(turn++%players.size()));
		}
		System.out.println(" ▷ 카드 배분이 완료되었습니다.");
		System.out.printf(" ▷ 남은 카드 %d 장\n",cardCase.size());
		System.out.println();
	}

	private void oneDevide(Player player) {
		CardOne[] temp = new CardOne[4];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = newCardOne();
		}
		player.setMyCard(temp);
	}

	private void allCut() {
		for (int i = 0; i < players.size(); i++) {
			if(!players.get(turn%players.size()).getIsCom()) userCut(players.get(turn%players.size()));
			else computerCut(players.get(turn%players.size()));
			turn++;
		}
		System.out.println();
		System.out.println(" ▷ 교환이 완료되었습니다.");
		System.out.println();
	}

	private void userCut(Player player) {
		CardOne[] temp = player.getMyCard().clone();
		int[] cutTemp = player.getChangeCnt();
		List<Integer> range = new ArrayList<Integer>(List.of(0, 1, 2, 3));
		List<Integer> numExchange = new ArrayList<Integer>();
		System.out.println();
		System.out.println("\t\t\t [ 0 ]   [ 1 ]   [ 2 ]   [ 3 ]");
		System.out.printf(" ▷ 보유 카드  : %s\n",Arrays.toString(player.getMyCard()));// 메이드 이상일 때 교환 추천
		System.out.printf(" ▷ 교환 추천  : ");// 메이드 이상일 때 교환 추천
		if(player.getChangeIdx().size() != 0) {
			for (int i = 0; i < player.getChangeIdx().size() - 1; i++) {
				System.out.printf("%s, ", player.getMyCard()[player.getChangeIdx().get(i)].getOne());
			}			
			System.out.println(player.getMyCard()[player.getChangeIdx().get(player.getChangeIdx().size() - 1)].getOne());
		}
		System.out.println();
		System.out.println();
		boolean isc = Input.getYerOrNo(" ▶ "+player.getName()+" 님 카드를 교환하시겠습니까? ( Y 또는 N ) : ");
		if (isc) {
			numExchange = Input.getIntArray(" ▶ 교환할 카드의 번호를 입력하세요 (스페이스로 구분) : ", range);
		}

		if (numExchange.isEmpty()) {
			System.out.println();
			System.out.println(" ▷ 카드를 교환하지 않았습니다.");
			System.out.println();
		} else {
			for (int i = 0; i < numExchange.size(); i++) {
				temp[numExchange.get(i)] = newCardOne();
			}
			System.out.println();
			cutTemp[cutCnt-1] = numExchange.size();
			player.setMyCard(temp);
			player.setChangeCnt(cutTemp);
		}
	}
	
	private void computerCut(Player player) {
		Set<Integer> chageIdx = new HashSet<Integer>(player.getChangeIdx());
		CardOne[] temp = player.getMyCard().clone();
		int[] cutTemp = player.getChangeCnt();
		
		for (Integer idx : chageIdx) {
			temp[idx] = newCardOne();
		}		
		cutTemp[cutCnt-1] = chageIdx.size();
		player.setMyCard(temp);	
		player.setChangeCnt(cutTemp);
		System.out.printf(" ▷ %s 님이 교환한 카드 장수는 %d 장 입니다.\n", player.getName(), chageIdx.size());
	}
	
	private CardOne newCardOne() {
		if(cardCase.size() == 0) {
			cardCase = new ArrayList<CardOne>(cardCasePost);
			Game.room.setCards(cardCase);
			cardCasePost.clear();
		}
		CardOne temp = cardCase.get(0);
		cardCasePost.add(cardCase.get(0));
		cardCase.remove(0);
		
		return temp;
	}

}
