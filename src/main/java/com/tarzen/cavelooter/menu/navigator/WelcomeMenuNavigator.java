package com.tarzen.cavelooter.menu.navigator;

import com.tarzen.cavelooter.enums.MenuEnum;
import com.tarzen.cavelooter.menu.navigator.service.WelcomeMenuActionsService;
import com.tarzen.cavelooter.menu.navigator.service.impl.WelcomeMenuActionsServiceImpl;
import com.tarzen.cavelooter.util.UserInputReader;
/**
 * 
 * This class acts on users choice from presented Welcome menu.
 * 
 * Responsible to show welcome menu options to user and
 * navigate to respective API based on user's choice.
 *
 */
public class WelcomeMenuNavigator implements IMenuNavigator{

	int userChoice = 0;
	
	private WelcomeMenuActionsService welcomeMenuService = new WelcomeMenuActionsServiceImpl();
	
	@Override
	public void startApp() {
		do {
			MenuEnum.MAIN_MENU_OPTIONS.getMenuProperties().forEach((menuOption)->{
				System.out.println(menuOption);
			});
			userChoice = UserInputReader.readInput();
			switch(userChoice) {
			case 1 :
				welcomeMenuService.createPlayerProfile();
				break;
			case 2:
				welcomeMenuService.organizeNewGame();
				break;
			case 3:
				welcomeMenuService.viewAllPlayers();
				break;
			case 4:
				welcomeMenuService.viewGameHistory();
				break;
			case 5:
				welcomeMenuService.resumeLastPlayedGame();
				break;
			case 6:
				System.out.println("You Exit the Game App");
				break;
			default:
				System.out.println("Please select a valid number.");
				userChoice = 0;
				break;
			}
			
		}while(userChoice!=6);
	}
}
