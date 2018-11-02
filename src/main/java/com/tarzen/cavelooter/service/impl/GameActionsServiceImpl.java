/**
 * 
 */
package com.tarzen.cavelooter.service.impl;

import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.enums.MenuEnum;
import com.tarzen.cavelooter.service.GameActionsService;
import com.tarzen.cavelooter.service.GameRefereeService;
import com.tarzen.cavelooter.util.UserInputReader;

/**
 * Responsible to present game options to user,navigate to realize user's selected game action.
 */
public class GameActionsServiceImpl implements GameActionsService{

	int userChoice = 0;
	
	private GameRefereeService caveLootReporterService = new GameRefereeServiceImpl();
	
	@Override
	public void playGame(Game game,boolean isResumedGame) {
		do {
			if(game.isGameOver() && game.getPlayer().getPower()>0) {
				System.out.println("Excellent!! You completed the Cave Loot with $"+game.getPlayer().getTotalLoot());
				break;
			}else if(game.isGameOver() ) {
				break;
			}
			
			MenuEnum.GAME_MENU_OPTIONS.getMenuProperties().forEach((menuOption)->{
				System.out.println(menuOption);
			});
			
			userChoice = UserInputReader.readInput();
			switch(userChoice) {
			case 1 :
				caveLootReporterService.updateGameOnAction(game,30);
				break;
			case 2:
				caveLootReporterService.updateGameOnAction(game,20);
				break;
			case 3:
				caveLootReporterService.updateGameOnAction(game,50);
				break;
			case 4:
				System.out.println("saving your game...");
				break;
			default:
				System.out.println("Please select valid number.");
				userChoice = 0;
				break;
			}
		}while(userChoice!=4);
	}
}
