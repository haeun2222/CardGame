package com.comeon.cardgame.tool;

import java.util.Objects;

public class CardOne {

	private String one;
	private int size;
	
	public static String[] shape = { "♣", "♥", "◆", "♠"};
	public static String[] number = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	CardOne() {
		int s = (int)(Math.random()*shape.length);
		int n = (int)(Math.random()*number.length);
		
		one = shape[s]+number[n];
		size = s + (n+1)*10;
	}

//	public CardOne(String value) {
//		this.one = value;
//		for (int i = 0; i < shape.length; i++) {
//			if(shape[i].equals(value.substring(0,1))) {
//				this.size += i;
//			}
//		}
//		for (int i = 0; i < number.length; i++) {
//			if(number[i].equals(value.substring(1))){
//				this.size += (i+1)*10;
//			}
//		}
//	}
	
	public String getOne() {
		return one;
	}

	public int getSize() {
		return size;
	}

	public void setOne(String one) {
		this.one = one;
	}

	@Override
	public int hashCode() {
		return Objects.hash(one, size);
	}

	@Override
	public boolean equals(Object obj) {
		boolean isc = false;
		CardOne other = (CardOne) obj;
		if(one.equals(other.getOne())) {
			isc = true;
		}
		
		return isc;
	}

	@Override
	public String toString() {
		return one;
	}
	
	
	
}
