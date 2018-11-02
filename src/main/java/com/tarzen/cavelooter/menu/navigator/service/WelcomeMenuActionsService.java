package com.tarzen.cavelooter.menu.navigator.service;

import com.tarzen.cavelooter.entity.Game;

public interface WelcomeMenuActionsService {

	void resumeLastPlayedGame();
	
	void secureGame(Game game);
	
	void organizeNewGame();
	
	void createPlayerProfile();
	
	void viewAllPlayers();
	
	void viewGameHistory();
}
