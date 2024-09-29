package com.comeon.cardgame.function;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InputTest {

	@Test
	public void test() {
//		Input.getNum("게임 모드를 입력해주세요. : ", 1, 3);
//		Input.getAnswer("게임을 끝내시겠습니까? (Y/N) : ");
//		Input.getString("닉네임을 입력해주세요. : ", 1, 5);
//		List<Integer> able = new ArrayList<Integer>(List.of(1,2,3));
//		String str = Input.getString("베팅 타입을 입력해주세요.", able);
		Input in = new Input();
		List<Integer> temp = new ArrayList<Integer>(List.of(1,2,3));
		System.out.println(in.getIntArray("ㄱㄱ", temp));
		
		
	}

}
