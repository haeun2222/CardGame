package com.comeon.cardgame.function;
import com.comeon.cardgame.tool.Player;
import com.comeon.cardgame.tool.Room;

public class Dealer {
	
	private static Dealer dealer;
	private int comCnt;
	
	private Dealer() {}
	
	public static Dealer getInstance() {
		if(dealer==null) {
			dealer = new Dealer();
		}
		return dealer;
	}
	
	public Room createRoom(int intMode) {
		String strMode = modeToStr(intMode);
		return new Room(strMode);
	}

	private String modeToStr(int intMode) {
		String strMode = switch (intMode) {
		case 2-> "하이바둑이";
		case 3->"리버스바둑이";
		default ->"로우바둑이";
		};
		return strMode;
	}

	public void addUser(int memberNum) {
		comCnt = 0;
		for (int i = 0; i < memberNum-1; i++) {
			System.out.printf(" ▷ %s 님이 ROOM에 입장하셨습니다.\n","computer_"+(++comCnt));
			Game.room.getPlayers().add(new Player("computer_"+(comCnt)));
			Game.room.getPlayers().get(i+1).setIsCom(true);
		}
		System.out.println();
	}
	
	public void addUser(Player user) {
		Game.room.getPlayers().add(user);
	}
	
	public void randomBoss() {
		int randomIndex = (int)(Math.random()*Game.room.getPlayers().size());
		Game.room.setBoss(randomIndex);
		System.out.printf(" ▷ ROOM 보스는 %s 님 입니다.\n", Game.room.getPlayers().get(randomIndex).getName());
	}
	
	public void payToDealer() {
		int pay = (int)(Game.room.getSeed()*0.05);
		System.out.printf(" ▷ 딜러비는 ￦%s 입니다.\n",Game.w.format(pay));
		System.out.println();
		Player user = Game.room.getPlayers().get(0);
		Player[] players = Game.room.getRanking();
		System.out.printf(" ▷ %s 님 : (+) ￦%s\n",
				players[0].getName(), Game.w.format(Game.room.getSeed()-pay-players[0].getTotalBetting()));		
		for (int i = 1; i < players.length; i++) {
			if(!players[i].getIsDie()) {
				System.out.printf(" ▷ %s 님 : (-) ￦%s\n",
				players[i].getName(), Game.w.format(players[i].getTotalBetting()));								
			}
		}			
		System.out.println();
		if(players[0].getName().equals(user.getName())) {
			user.setMoney(user.getMoney()+Game.room.getSeed()-pay-user.getTotalBetting());
		} else {
			user.setMoney(user.getMoney()-user.getTotalBetting());
		}
		System.out.printf(" ▷ %s 님 보유 금액 : %s\n", user.getName(), Game.w.format(user.getMoney()));
		System.out.println();
	}

}
