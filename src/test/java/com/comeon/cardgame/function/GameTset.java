package com.comeon.cardgame.function;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTset {

	@Test
	public void test() {
		Game game = new Game();
		game.start();
		game.play();
	}

}
