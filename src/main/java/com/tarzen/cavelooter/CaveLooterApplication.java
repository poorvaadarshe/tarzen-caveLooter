package com.tarzen.cavelooter;

import com.tarzen.cavelooter.menu.navigator.IMenuNavigator;
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
		IMenuNavigator userMenuService = new WelcomeMenuNavigator();
		userMenuService.startApp();
	}
}