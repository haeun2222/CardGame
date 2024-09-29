package com.comeon.cardgame.tool;

import java.util.ArrayList;
import java.util.List;

public class CardCase {

	private List<CardOne> cardcase;
	
	public CardCase() {
		cardcase = new ArrayList<CardOne>();
		make();
	}
	
	private void make() {
		int cnt = 0;
		while(true) {
			CardOne card = new CardOne();
			if(!cardcase.contains(card)) {
				cardcase.add(card);
				cnt++;
			}

			if(cnt==CardOne.shape.length*CardOne.number.length) {
				break;
			}
		}
	}

	public List<CardOne> getCardcase() {
		return cardcase;
	}

}
