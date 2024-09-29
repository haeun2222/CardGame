package com.comeon.cardgame.function;

import java.util.Arrays;
import java.util.List;

import com.comeon.cardgame.tool.Player;

public class Print {

	public void roomInfo() {
		System.out.println(" ▷ 게임 모드 : " + Game.room.getMode());
		System.out.println(" ▷ ROOM 시드 : " + Game.w.format(Game.room.getSeed()));
		System.out.println(" ▷ 남은 카드 : " + Game.room.getCards().size()+" 장");
		System.out.println();
	}

	public void playersInfo() {
		int turn = Game.room.getBoss();
		List<Player> players = Game.room.getPlayers();
		for (int i = 0; i < players.size(); i++) {	
			System.out.printf(" ▷ [%s]          %d/%d/%d          ￦%s\n",
			players.get(turn%players.size()).getName(),
			players.get(turn%players.size()).getChangeCnt()[0],
			players.get(turn%players.size()).getChangeCnt()[1],
			players.get(turn%players.size()).getChangeCnt()[2],
			Game.w.format(players.get(turn%players.size()).getMoney())) ;// [닉네임] 교환카드개수 보유머니
			turn++;
		}
		System.out.println();
		myInfo();
		System.out.println();
	}

	public void myInfo() {
		Player user = Game.room.getPlayers().get(0);
		System.out.printf(" ▷ %s 님 보유 카드 : " + Arrays.toString(user.getMyCard()) + "\n", user.getName());// 보유카드
		System.out.println(" ▷ 해당 족보 : " + user.getJokbo());// 보유카드+ 족보
		System.out.printf(" ▷ 교환 추천  : ");// 메이드 이상일 때 교환 추천
		if(user.getChangeIdx().size() != 0) {
			for (int i = 0; i < user.getChangeIdx().size() - 1; i++) {
				System.out.printf("%s, ", user.getMyCard()[user.getChangeIdx().get(i)].getOne());
			}			
			System.out.println(user.getMyCard()[user.getChangeIdx().get(user.getChangeIdx().size() - 1)].getOne());
		}
		System.out.println();
	}

	public void ranking() {
		Player[] players = Game.room.getRanking();
		System.out.println(" ▷ RanKing");
		for (int i = 0; i < players.length; i++) {
			if(!players[i].getIsDie()) {
				System.out.printf(" ▷ [%d등]    %s    %s\n",i+1, players[i].getName(), players[i].getJokbo());
			}
		}
		System.out.println();
	}
}
