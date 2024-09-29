package com.comeon.cardgame.function;

import java.util.List;
import org.junit.Test;
import com.comeon.cardgame.tool.CardOne;
import com.comeon.cardgame.tool.Player;

public class CompareReverseITest {

	@Test
	public void test() {
		//TODO SH009 CompareReverse()
		
		CardOne[][] card = new CardOne[][]{
//			{ new CardOne("♣5"), new CardOne("♥5"), new CardOne("◆5"), new CardOne("♠5")}, // 유저
//			{new CardOne("♠10"), new CardOne("♠J"), new CardOne("♠Q"), new CardOne("♠K")}, // 1
//			{ new CardOne("♠9"), new CardOne("♠J"), new CardOne("♠Q"), new CardOne("♠K")}, // 2
//			{ new CardOne("♠9"), new CardOne("♠10"), new CardOne("♠Q"), new CardOne("♠K")}, // 3
//			{ new CardOne("♠2"), new CardOne("♠6"), new CardOne("♠8"), new CardOne("♠10")}, // 4
//			
//			{ new CardOne("♣A"), new CardOne("♣2"), new CardOne("♣5"), new CardOne("♥7")}, // 5
//			{ new CardOne("♣6"), new CardOne("♣9"), new CardOne("♣10"), new CardOne("♥K")}, // 6
//			
//			{ new CardOne("♣6"), new CardOne("♣10"), new CardOne("♠K"), new CardOne("♥K")}, // 7
//			{ new CardOne("♣6"), new CardOne("♣8"), new CardOne("♠9"), new CardOne("♠J")}, // 8
//			
//			{ new CardOne("♥4"), new CardOne("♠6"), new CardOne("♣10"), new CardOne("◆K")}, // 9
		};
		
		Dealer dealer = Dealer.getInstance();
		Game.room = dealer.createRoom(1);
		List<Player> players = Game.room.getPlayers();
//		dealer.addUser("유저");
		for (int i = 0; i < 9; i++) {
//			dealer.addUser();			
		}
		for(int i = 0; i<10; i++) {
			players.get(i).setMyCard(card[i]);
		}
		
//		CompareImpl ci = dealer.createCompare(3);
//		ci.makeJokboAndChange();
//		ci.comparePlayers();
//		for (Player player : Game.room.getRanking()) {
//			System.out.println(player.getName() + " : "+player.getJokbo());
		}
	}


