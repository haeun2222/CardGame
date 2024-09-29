package com.comeon.cardgame.tool;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private String mode;
	private List<CardOne> cards;
	private List<Player> players;
	private int seed;
	private int boss;
	private Player[] ranking;
	private int dieCnt;
	
	private boolean isUserLose;
	private boolean isGameEnd;
	
	public Room(String mode) {
		this.mode = mode;
		cards = new CardCase().getCardcase();
		players = new ArrayList<Player>();
		seed = 0;
		boss = -1;
		dieCnt = 0;
		isUserLose = false;
		isGameEnd = false;
	}
	
	public String getMode() {
		return mode;
	}
	
	public List<CardOne> getCards() {
		return cards;
	}

	public void setCards(List<CardOne> cards) {
		this.cards = cards;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public int getBoss() {
		return boss;
	}

	public void setBoss(int boss) {
		this.boss = boss;
	}

	public Player[] getRanking() {
		return ranking;
	}

	public void setRanking(Player[] ranking) {
		this.ranking = ranking;
	}

	public int getDieCnt() {
		return dieCnt;
	}

	public void setDieCnt(int dieCnt) {
		this.dieCnt = dieCnt;
	}

	public boolean getIsUserLose() {
		return isUserLose;
	}

	public void setIsUserLose(boolean isUserLose) {
		this.isUserLose = isUserLose;
	}

	public boolean getIsGameEnd() {
		return isGameEnd;
	}

	public void setIsGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}
	
	
}