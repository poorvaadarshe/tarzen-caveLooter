package com.tarzen.cavelooter;

import com.tarzen.cavelooter.menu.navigator.WelcomeMenuNavigator;

/**
 * 
 * @author Poorva Adarshe
 * 
 * Triggering point of the Game Application.
 *
 */
public class CaveLooterApplication {

	public static void main(String[] args) {
		WelcomeMenuNavigator userMenuService = new WelcomeMenuNavigator();
		userMenuService.startApp();
	}
}