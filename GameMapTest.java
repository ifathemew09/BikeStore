package main.game;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameMapTest {

	@Test
	void testGetHeight() {
		int min = 5;
		GameMap gMap = new GameMap(min, min);
		int x = gMap.getHeight();
		if(x > min) {
			assertTrue(x > min);
		}
	}
	
	@Test
	void testGetWidth() {
		int min = 5;
		int min2 = 4;
		GameMap gMap = new GameMap(min, min);
		int y = gMap.getWidth();
		if(y > min) {
			System.out.println("valid");
			assertTrue(y > min);
		}
		if(y < min2) {
			System.out.println("invalid");
			assertTrue(y < min2);
		}
	}
}
