package com.comeon.cardgame.function;

import java.util.List;
import org.junit.Test;
import com.comeon.cardgame.tool.CardOne;
import com.comeon.cardgame.tool.Player;

public class CompareImplTest {

	@Test
	public void test() {
		//TODO SH001 기본 테스트 환경 세팅
		
		// 1. CardOne(String value) 생성자 추가
//		CardOne(String value) {
//			this.one = value;
//			for (int i = 0; i < Shape.values().length; i++) {
//				if(Shape.values()[i].value.equals(value.substring(0,1))) {
//					this.size += Shape.values()[i].ordinal();
//				}
//			}
//			for (int i = 0; i < Number.values().length; i++) {
//				if(Number.values()[i].value.equals(value.substring(1))){
//					this.size += (Number.values()[i].ordinal()+1)*10;
//				}
//			}
//		}
		
		// 2. myCard 생성
//		CardOne[] myCard = {new CardOne("◆3"), new CardOne("♥2"), new CardOne("♠A"), new CardOne("♣4") };
		
		// 3. 유저 리스트 생성 및 myCard 세팅
//		List<Player> players = new ArrayList<Player>();
//		Dealer dealer = Dealer.getInstance();
//		Game.room = dealer.createRoom(1);
//		List<Player> players = Game.room.getPlayers();
//		dealer.addUser("유저");
//		dealer.addUser();

		// 4. test class 생성
//		CompareImpl ci = new CompareImpl();

		//TODO SH002 bubbleSort()
//		ci.bubbleSort(players.get(0));
//		CardOne[] toCard = {new CardOne("♠A"), new CardOne("♥2"), new CardOne("◆3"), new CardOne("♣4") };
//		assertArrayEquals(toCard, players.get(0).getMyCard());
//		CardOne[] myCard2 = {new CardOne("♠6"), new CardOne("♥K"), new CardOne("◆10"), new CardOne("♣K") };
//		players.get(0).setMyCard(myCard2);
//		ci.bubbleSort(players.get(0));
//		CardOne[] toCard2 =  {new CardOne("♠6"), new CardOne("◆10"), new CardOne("♣K"), new CardOne("♥K") };
//		assertArrayEquals(toCard2, players.get(0).getMyCard());

		//TODO SH003 separateCard()
//		CardOne[] card = { new CardOne("♥4"), new CardOne("♠6"), new CardOne("♠10"), new CardOne("♣K") };
//		ci.separateCard(card);
//		String[] shape = {"♥","♠","♠","♣"};
//		String[] number = {"4","6","10","K"};
//		assertArrayEquals(ci.nowPShape, shape);
//		assertArrayEquals(ci.nowPNumber, number);
		
		//TODO SH004 findValidValue()
		// 메이드
//		CardOne[] card1 =  { new CardOne("♠6"), new CardOne("♣9"), new CardOne("◆10"), new CardOne("♥K") };
//		ci.separateCard(card1);
//		ci.findValidValue(card1);
//		List<CardOne> card1Valid = new ArrayList<CardOne>(List.of(card1));
//		assertEquals(card1Valid, ci.validValue);
//		assertEquals(true, ci.changeIdx.isEmpty());
//		// 베이스
//		CardOne[] card2 = { new CardOne("♥4"), new CardOne("♠6"), new CardOne("♠10"), new CardOne("♣K") };
//		ci.separateCard(card2);
//		ci.findValidValue(card2);
//		List<CardOne> card2Valid = new ArrayList<CardOne>(List.of(new CardOne("♥4"), new CardOne("♠6"),  new CardOne("♣K")));
//		Set<Integer> card2Change = new HashSet<Integer>(List.of(2));
//		assertEquals(card2Valid, ci.validValue);
//		assertEquals(card2Change, ci.changeIdx);
//		// 투베이스
//		CardOne[] card3 = { new CardOne("♠6"), new CardOne("♣10"), new CardOne("♥10"), new CardOne("♠10") };
//		ci.separateCard(card3);
//		ci.findValidValue(card3);
//		List<CardOne> card3Valid = new ArrayList<CardOne>(List.of(new CardOne("♠6"), new CardOne("♣10")));
//		Set<Integer> card3Change = new HashSet<Integer>(List.of(2,3));
//		assertEquals(card3Valid, ci.validValue);
//		assertEquals(card3Change, ci.changeIdx);
//		// 무탑_숫자
//		CardOne[] card4 = { new CardOne("♣9"), new CardOne("♥9"), new CardOne("◆9"), new CardOne("♠9") };
//		ci.separateCard(card4);
//		ci.findValidValue(card4);
//		List<CardOne> card4Valid = new ArrayList<CardOne>(List.of(new CardOne("♣9")));
//		Set<Integer> card4Change = new HashSet<Integer>(List.of(1,2,3));
//		assertEquals(card4Valid, ci.validValue);
//		assertEquals(card4Change, ci.changeIdx);
//		// 무탑_무늬
//		CardOne[] card5 = { new CardOne("♣6"), new CardOne("♣8"), new CardOne("♣9"), new CardOne("♣J") };
//		ci.separateCard(card5);
//		ci.findValidValue(card5);
//		List<CardOne> card5Valid = new ArrayList<CardOne>(List.of(new CardOne("♣6")));
//		Set<Integer> card5Change = new HashSet<Integer>(List.of(1,2,3));
//		assertEquals(card5Valid, ci.validValue);
//		assertEquals(card5Change, ci.changeIdx);
		
		// TODO SH005 makeJokbo();
//		// 골프
//		CardOne[] card1 = {new CardOne("♠A"), new CardOne("♥2"), new CardOne("◆3"), new CardOne("♣4")}; 
//		ci.separateCard(card1); 
//		ci.findValidValue(card1); 
//		ci.makeJokboName(card1); 
//		String jokbo1 = ci.jokbo; 
//		assertEquals("골프", jokbo1); 
//		// 세컨드 
//		CardOne[] card2 = { new CardOne("♥A"), new CardOne("♠2"), new CardOne("♣3"), new CardOne("◆5") };
//		ci.separateCard(card2); 
//		ci.findValidValue(card2);
//		ci.makeJokboName(card2);
//		String jokbo2 = ci.jokbo;
//		assertEquals( "세컨드" , jokbo2); 
//		// 써드
//		CardOne[] card3 = { new CardOne("♠A"), new CardOne("♣2"), new CardOne("◆4"), new CardOne("♥5")}; 
//		ci.separateCard(card3); 
//		ci.findValidValue(card3);
//		ci.makeJokboName(card3);
//		String jokbo3 = ci.jokbo; 
//		assertEquals("써드", jokbo3); 
//		// 메이드 탑K 
//		CardOne[] card4 = { new CardOne("♠6"), new CardOne("♣9"), new CardOne("◆10"), new CardOne("♥K") };
//		ci.separateCard(card4); 
//		ci.findValidValue(card4);
//		ci.makeJokboName(card4);
//		String jokbo4 = ci.jokbo;
//		assertEquals("메이드 탑K", jokbo4); 
//		// 베이스 탑7 
//		CardOne[] card5 = { new CardOne("♠A"), new CardOne("♥2"), new CardOne("♠5"), new CardOne("♣7") };
//		ci.separateCard(card5); 
//		ci.findValidValue(card5);
//		ci. makeJokboName(card5); 
//		String jokbo5 = ci.jokbo;
//		assertEquals("베이스 탑7", jokbo5);
//		// 베이스 탑K_숫자 
//		CardOne[] card6 = { new CardOne("♠6"), new CardOne("◆10"), new CardOne("♣K"), new CardOne("♥K") };
//		ci.separateCard(card6); 
//		ci.findValidValue(card6);
//		ci. makeJokboName(card6); 
//		String jokbo6 = ci.jokbo;
//		assertEquals("베이스 탑K", jokbo6);
//		// 베이스 탑K_무늬 
//		CardOne[] card7 = { new CardOne("♥4"), new CardOne("♠6"), new CardOne("♠10"), new CardOne("♣K") };
//		ci.separateCard(card7); 
//		ci.findValidValue(card7);
//		ci. makeJokboName(card7); 
//		String jokbo7 = ci.jokbo;
//		assertEquals("베이스 탑K", jokbo7);
//		// 투베이스 탑8 
//		CardOne[] card8 = { new CardOne("♣2"), new CardOne("♣6"), new CardOne("♥8"), new CardOne("♥10") };
//		ci.separateCard(card8); 
//		ci.findValidValue(card8);
//		ci. makeJokboName(card8); 
//		String jokbo8 = ci.jokbo;
//		assertEquals("투베이스 탑8", jokbo8);
//		// 투베이스 탑10_숫자 
//		CardOne[] card9 = { new CardOne("♠6"), new CardOne("♣10"), new CardOne("♥10"), new CardOne("♠10") };
//		ci.separateCard(card9); 
//		ci.findValidValue(card9);
//		ci. makeJokboName(card9); 
//		String jokbo9 = ci.jokbo;
//		assertEquals("투베이스 탑10", jokbo9);
//		// 투베이스 탑10_무늬 
//		CardOne[] card10 = { new CardOne("♣2"), new CardOne("♣5"), new CardOne("♣6"), new CardOne("♥10")};
//		ci.separateCard(card10); 
//		ci.findValidValue(card10);
//		ci. makeJokboName(card10); 
//		String jokbo10 = ci.jokbo;
//		assertEquals("투베이스 탑10", jokbo10);
//		// 무탑9 
//		CardOne[] card11 = { new CardOne("♣9"), new CardOne("♥9"), new CardOne("◆9"), new CardOne("♠9") };
//		ci.separateCard(card11); 
//		ci.findValidValue(card11);
//		ci. makeJokboName(card11); 
//		String jokbo11 = ci.jokbo;
//		assertEquals("무탑9", jokbo11);
//		// 무탑6 
//		CardOne[] card12 = { new CardOne("♣6"), new CardOne("♣8"), new CardOne("♣9"), new CardOne("♣J") };
//		ci.separateCard(card12); 
//		ci.findValidValue(card12);
//		ci. makeJokboName(card12); 
//		String jokbo12 = ci.jokbo;
//		assertEquals("무탑6", jokbo12);
		
		//TODO SH006 makeJokboAndChange()
		
		CardOne[][] card = new CardOne[][]{
//			{new CardOne("♠A"), new CardOne("♥2"), new CardOne("◆3"), new CardOne("♣4")}, // 1
//			{ new CardOne("♠6"), new CardOne("♣10"), new CardOne("♥10"), new CardOne("♠10")}, // 9
//			{ new CardOne("♥A"), new CardOne("♠2"), new CardOne("♣3"), new CardOne("◆5")}, // 2
//			{ new CardOne("♣2"), new CardOne("♣5"), new CardOne("♣6"), new CardOne("♥10")}, // 10
//			{ new CardOne("♣2"), new CardOne("♣6"), new CardOne("♥8"), new CardOne("♥10")}, // 8
//			{ new CardOne("♠6"), new CardOne("♣9"), new CardOne("◆10"), new CardOne("♥K")}, // 4
//			{ new CardOne("♠A"), new CardOne("♥2"), new CardOne("♠5"), new CardOne("♣7")}, // 5
//			{ new CardOne("♠6"), new CardOne("◆10"), new CardOne("♣K"), new CardOne("♥K")}, // 6
//			{ new CardOne("♣6"), new CardOne("♣8"), new CardOne("♣9"), new CardOne("♣J")}, // 12
//			{ new CardOne("♥4"), new CardOne("♠6"), new CardOne("♠10"), new CardOne("♣K")}, // 7
//			{ new CardOne("♣9"), new CardOne("♥9"), new CardOne("◆9"), new CardOne("♠9")}, // 11
//			{ new CardOne("♠A"), new CardOne("♣2"), new CardOne("◆4"), new CardOne("♥5")} // 3
		};
		
		Dealer dealer = Dealer.getInstance();
		Game.room = dealer.createRoom(1);
		List<Player> players = Game.room.getPlayers();
//		dealer.addUser("유저");
		for (int i = 0; i < 11; i++) {
//			dealer.addUser();			
		}
		for(int i = 0; i<12; i++) {
			players.get(i).setMyCard(card[i]);
		}
		
//		CompareImpl ci = dealer.createCompare(1);
//		
//		ci.makeJokboAndChange();
//		
//		//TODO SH007 calScore()
////		for (Player player : players) {
////			System.out.println(player.getJokbo() + " : "+ ci.calScore(player));
////		}
//		
//		//TODO SH008 comparePlayers()
//		ci.comparePlayers();
//		for (Player player : Game.room.getRanking()) {
//			System.out.println(player.getName() + " : "+player.getJokbo());
//		}
	}

}
