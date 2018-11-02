package com.tarzen.cavelooter.util;

import java.util.Random;

public class RandomPropertiesGeneratorUtil {

	private static Random randomNumber = new Random();

	public static int loadBarriersCapacity(int minLimit, int delta) {
		int i = minLimit + randomNumber.nextInt(delta);
		return i; 
	}

	public static int loadBonus() {
		int x = 50*randomNumber.nextInt(50);
		return x;
	}
}
