package com.comeon.cardgame.tool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
	
	private String name;
	private int[] changeCnt;
	private int money;
	private CardOne[] myCard;
	private String jokbo;
	private List<Integer> changeIdx;
	private boolean isDie;
	private boolean isCom = false;
	private int totalBetting;
	
	public Player(String name) {
		this.name = name;
		changeCnt = new int[3];
		money = 100000000;
		myCard = new CardOne[4];
		jokbo = "";
		changeIdx = new ArrayList<Integer>();
		isDie = false;
		totalBetting = 0;
	}

	public String getName() {
		return name;
	}
	
	public int[] getChangeCnt() {
		return changeCnt;
	}

	public void setChangeCnt(int[] changeCnt) {
		this.changeCnt = changeCnt;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public CardOne[] getMyCard() {
		return myCard;
	}

	public void setMyCard(CardOne[] myCard) {
		this.myCard = myCard;
	}

	public String getJokbo() {
		return jokbo;
	}

	public void setJokbo(String jokbo) {
		this.jokbo = jokbo;
	}

	public List<Integer> getChangeIdx() {
		return changeIdx;
	}

	public void setChangeIdx(ArrayList<Integer> changeIdx) {
		this.changeIdx = changeIdx;
	}

	public boolean getIsDie() {
		return isDie;
	}

	public void setIsDie(boolean isDie) {
		this.isDie = isDie;
	}

	public boolean getIsCom() {
		return isCom;
	}

	public void setIsCom(boolean isCom) {
		this.isCom = isCom;
	}

	public int getTotalBetting() {
		return totalBetting;
	}

	public void setTotalBetting(int totalBetting) {
		this.totalBetting = totalBetting;
	}

	
}
