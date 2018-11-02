package com.tarzen.cavelooter.util;

public class InputValidationUtil {
	public static int validateInputValue(String menuInput) {
		try {
			return Integer.parseInt(menuInput);

		} catch (NumberFormatException e) {
			System.out.println("Invalid value entered!");
			return 0;
		}
	}
}
