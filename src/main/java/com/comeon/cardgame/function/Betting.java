package com.comeon.cardgame.function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comeon.cardgame.tool.Player;

/**
 * 베팅 타입 경우의 수, 콜 금액 등을 판단 및 계산하는 메소드
 * @author 하은
 * */
public class Betting {
	
	private static Betting betting;
	private List<Player> players;
	private int turn;	
	private Player currentPlayer;
	private int currentBetMoney;
	private Map<Player, Integer> playerTurnPay;

	private int raiseCnt;
	private int callCnt;
	
	private Betting() {};
	
	public static Betting getInstance() {
		if(betting==null) {
			betting = new Betting();
		}
		return betting;
	}
	
	public void payAnte() {
		System.out.println();
		System.out.println(" ▷ 보스부터 앤티(￦100,000)를 지불합니다.");
		System.out.println();
		players = Game.room.getPlayers();
		turn = Game.room.getBoss();
		for (int i = 0; i < players.size(); i++) {
			Game.room.setSeed(Game.room.getSeed()+100000);
			currentPlayer = players.get(turn++%Game.room.getPlayers().size());
			currentPlayer.setMoney(currentPlayer.getMoney()-100000);
			currentPlayer.setTotalBetting(100000);
			System.out.printf(" ▷ %s 님의 현재 잔액은 ￦%s 입니다.\n",currentPlayer.getName(), Game.w.format(currentPlayer.getMoney()));
		}
		System.out.println();
	}
	
	public void bettingProcess() {
		System.out.println(" ▷ 베팅을 시작합니다.");
		System.out.println();
		playerPayClear();
		while (true) {
			currentPlayer = players.get(turn++%Game.room.getPlayers().size()); 
			if(!currentPlayer.getIsDie()) {
				personalBettingProcess();				
			}
			if(!currentPlayer.getIsCom() && currentPlayer.getIsDie()) {
				Game.room.setIsUserLose(true);
				break;
			} else if (Game.room.getDieCnt()==players.size()-1 ) {
				Game.room.setIsGameEnd(true);		
				break;
			} else if (callCnt==players.size()-1) {
				break;
			}
		}
		System.out.println(" ▷ 베팅이 종료되었습니다.");
		System.out.println();
	}
	
	private void playerPayClear() {
		turn = Game.room.getBoss();
		currentBetMoney = 0;
		raiseCnt = 0;
		callCnt = 0;
		playerTurnPay = new HashMap<Player, Integer>();
		for (Player player : players) {
			playerTurnPay.put(player, 0);
		}
	}
	
	private void personalBettingProcess() {	
		System.out.printf(" ▷ 현재 차례는 %s 님 입니다.\n", currentPlayer.getName());
	    List<Integer> turnType = turnType();
	    int choice = choiceBetting(turnType);
	    int betMoney = choiceType(choice);
	    if(betMoney != 0) calBetting(betMoney);
	    System.out.println();
	}
	
	private List<Integer> turnType() {
		if(raiseCnt==3) {
			return new ArrayList<Integer>(List.of(1,4));	// 다이, 콜만 가능
		}
		else if(raiseCnt>=1&&raiseCnt<3) {	 
			return new ArrayList<Integer>(List.of(1,2,3,4,5));	// 모두 가능
		}
		else { // boss 일 때
			return new ArrayList<Integer>(List.of(1,2,3));	// 다이, 하프, 쿼터만 가능
		}
	}
	
	private int choiceBetting(List<Integer> turnType) {
		int n = 0;

		if (currentPlayer.getIsCom()) {
			n =  computerBetting(turnType);
		} else {
			n = userBetting(turnType);
		}
		return n;

	}
	
	private int computerBetting(List<Integer> turnType) {
		int n = 1;
		if(currentPlayer.getJokbo().contains("메이드") || currentPlayer.getJokbo().contains("베이스")) {
			n = turnType.get((int)(Math.random()*(turnType.size()-1))+1);			
		} 
		System.out.printf(" ▷ %s 님이 %s를 선택하셨습니다.\n",currentPlayer.getName(), bettingType(n));
		return n;
	}
	
	private int userBetting(List<Integer> turnType) {
		System.out.printf(" ▷ %s 님이 베팅하실 차례입니다.\n", currentPlayer.getName());
		System.out.printf(" ▷ 현재 가능한 베팅 타입 : ");
		for (Integer type : turnType) {;
			System.out.printf("[%d] %s(",type, bettingType(type));
			System.out.printf("￦%s)   ", Game.w.format(branch(type)));
		}
		System.out.println();
		System.out.println();
		int choice = Input.getNum(" ▶ 베팅 타입을 선택해주세요 : ", turnType); 
		System.out.println();
		System.out.printf(" ▷ %s 님이 %s를 선택하셨습니다.\n",currentPlayer.getName(),bettingType(choice));
		return choice;
	}
	
	private String bettingType(int type) {
		String sType = switch (type) {
		case 1 ->"다이";
		case 2->"하프";
		case 3->"쿼터";
		case 4->"콜";	
		default ->"따당";
		};
		return sType;
	}

	private int choiceType(int choice) {	
		int betMoney;
		switch (choice) {
		case 1 -> {
			currentPlayer.setIsDie(true);
			Game.room.setDieCnt(Game.room.getDieCnt()+1);
			System.out.printf(" ▷ %s 님이 퇴장하셨습니다. (남은 플레이어 수 : %d 명)\n", currentPlayer.getName(), Game.room.getPlayers().size()-Game.room.getDieCnt());
			betMoney = branch(1);
		}
		case 2 -> {
			raiseCnt++;
			callCnt=0;
			betMoney = branch(2);
		}
		case 3 -> {
			raiseCnt++;
			callCnt=0;
			betMoney = branch(3);
		}
		case 4 -> {
			callCnt++;
			betMoney = branch(4);
		}
		default -> {
			raiseCnt++;
			callCnt=0;
			betMoney = branch(5);
		}
		};
		return betMoney;
	}
	
	private int branch(int choice) {
		int betMoney = switch (choice) {
		case 1 -> dieBetting();
		case 2 -> harfBetting();
		case 3 -> quarterBetting();
		case 4 -> callBetting();
		default ->ddadangBetting();
		};
		return betMoney;
	}
	
	private void calBetting(int betMoney) {
		if(betMoney!=0) {
			if(callCnt == 0) currentBetMoney = betMoney;
			currentPlayer.setMoney(currentPlayer.getMoney()-betMoney);
			Game.room.setSeed(Game.room.getSeed()+betMoney);
			playerTurnPay.put(currentPlayer, betMoney);
			currentPlayer.setTotalBetting(betMoney);
		}
		System.out.printf(" ▷ %s 님 베팅 금액 : ￦%s, 현재 잔액 : ￦ %s, ROOM 시드 : ￦ %s\n", 
													currentPlayer.getName(), Game.w.format(betMoney), Game.w.format(currentPlayer.getMoney()), Game.w.format(Game.room.getSeed()));
		System.out.printf(" ▷ 남은 레이즈 횟수 : %d 회", 3-raiseCnt);
		System.out.println();
	}
	
	private int harfBetting(){	
		return currentBetMoney + ((Game.room.getSeed() + currentBetMoney)/2);
	}

	private int quarterBetting(){	
		return currentBetMoney + ((Game.room.getSeed() + currentBetMoney)/4);
	}

	private int callBetting() {	
		return currentBetMoney - playerTurnPay.get(currentPlayer);
	}


	private int ddadangBetting() {	
		return currentBetMoney + (currentBetMoney*2);
	}

	private int dieBetting() {
		return 0;
	}
}

