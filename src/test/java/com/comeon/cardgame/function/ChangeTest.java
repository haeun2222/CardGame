package com.comeon.cardgame.function;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.comeon.cardgame.tool.Player;

public class ChangeTest {

	@Test
	public void test() {
		
		Dealer dealer = Dealer.getInstance();
		Game.room = dealer.createRoom(1);
		List<Player> players = Game.room.getPlayers();
//		dealer.addUser("유저");
		for (int i = 0; i < 5; i++) {
//			dealer.addUser();	
		}
		dealer.randomBoss();
//		Change ch = new Change();
		
		//TODO JI001 devide()
//		System.out.println(Game.room.getCards().size());
//		ch.devideOrCut();
//		System.out.println(Game.room.getCards().size());
		
		//TODO JI002 userCut()
//		System.out.println(Arrays.toString(players.get(0).getMyCard()));
//		ch.userCut(players.get(0));
//		System.out.println(Arrays.toString(players.get(0).getMyCard()));
		
		//TODO JI003 computerCut()
//		CompareImpl compare = dealer.createCompare(1);
//		
//		compare.makeJokboAndChange();
//		for (int i = 1; i < players.size(); i++) {
//			System.out.println(players.get(i).getName());
//			System.out.println(Arrays.toString(players.get(i).getMyCard()));
//			System.out.println(players.get(i).getJokbo());
//			System.out.println(players.get(i).getChangeIdx());
//			ch.computerCut(players.get(i));
//			System.out.println(Arrays.toString(players.get(i).getMyCard()));
//			System.out.println("=============================");
//		}
		
		//TODO JI004 allCut()
//		for (Player player : players) {
//			System.out.println(player.getName() + " : " +Arrays.toString(player.getMyCard()));
//		}
//		ch.allCut();
//		for (Player player : players) {
//			System.out.println(player.getName() + " : " + Arrays.toString(player.getMyCard()));
//		}

		//TODO JI005 newCardCase()
//		ch.devideOrCut();
//		ch.devideOrCut();
		
//		ch.devideOrCut();
//		CompareImpl compare = dealer.createCompare(1);
//		
//		compare.makeJokboAndChange();
		
	}

}
