package com.comeon.cardgame.function;

import java.text.DecimalFormat;

import com.comeon.cardgame.tool.Player;
import com.comeon.cardgame.tool.Room;

public class Game {
	static Room room; // player -> room.getPlayers().get(idx);
	public static DecimalFormat w = new DecimalFormat("###,###");
	private String name;
	private int mode;
	private int memberNum;
	
	private Player user;
	private Dealer dealer;
	private Change change;
	private Betting betting;
	private CompareImpl compare;
	private Print print;

	public Game() {
		dealer = Dealer.getInstance();
		change = Change.getInstance();
		betting = Betting.getInstance();
		print = new Print();
	}

	public void start() {
		name = Input.getString(" ▶ 닉네임을 입력해주세요 : ", 1, 5);
		user = new Player(name);
		System.out.println();
		System.out.println(" ▷ [1] 로우바둑이\t[2] 하이바둑이\t [3] 리버스바둑이");
		mode = Input.getNum(" ▶ 게임 모드를 입력해주세요 : ", 1, 3);
		System.out.println();
		memberNum = Input.getNum(" ▶ ROOM의 인원 수를 정해주세요. (본인 포함 최대 5명) : ", 2, 5);
		System.out.println();
	}

	public void play() {
		while (true) {
			System.out.println(" ▷ ROOM에 입장합니다.");
			room = dealer.createRoom(mode);
			dealer.addUser(user);
			user.setTotalBetting(0);
			dealer.addUser(memberNum);
			dealer.randomBoss();
			betting.payAnte();
			print.roomInfo();
			compare = enterMode(mode);
			changeAndBetting();
			compare.comparePlayers();
			print.ranking();
			dealer.payToDealer();
			if (!room.getIsUserLose()) {
				System.out.printf(" ▷ %s 님이 승리했습니다.\n", name);
				System.out.println();
			} else if ( room.getIsGameEnd() || room.getIsUserLose()) {
				System.out.printf(" ▷ %s 님이 패배했습니다.\n", name);
			}
			System.out.println();
			if(!newGame()) {
				System.out.println(" ▷ 게임이 종료되었습니다.");
				break;
			}
		}
	}

	private void changeAndBetting() {
		for (int i = 0; i < 4; i++) {
			change.devideOrCut();
			compare.makeJokboAndChange();
			if(i==0) {
				print.myInfo();
			} else {
				print.playersInfo();
			}
			betting.bettingProcess();
			if (room.getIsUserLose() || room.getIsGameEnd()) {
				break;
			}
		}
	}
	
	private boolean newGame() {
		if(Game.room.getPlayers().get(0).getMoney() < 10000000) {
			System.out.printf(" ▷ %s 님의 보유금액이 1,000만원 이하이므로 게임을 종료합니다.\n", name);
			System.out.println();
			return false;
		}
		
		boolean answer = Input.getYerOrNo(" ▶ "+name+" 님 새로운 게임을 하시겠습니까? ( Y 또는 N ) : ");	
		return answer;
	}
	
	private CompareImpl enterMode(int mode) {
		CompareImpl compare = switch (mode) {
		case 1 ->CompareLow.getInstance();
		case 2 ->CompareHigh.getInstance();
		default ->CompareReverse.getInstance();
		};
		
		return compare;
	}
}
