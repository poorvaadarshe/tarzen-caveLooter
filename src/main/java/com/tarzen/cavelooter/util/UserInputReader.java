package com.tarzen.cavelooter.util;

import java.util.Scanner;

public class UserInputReader {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int readInput() {
		String menuInput = readStringInput();
		return InputValidationUtil.validateInputValue(menuInput);
	}

	public static String readStringInput() {
		return scanner.next();
	}
}
