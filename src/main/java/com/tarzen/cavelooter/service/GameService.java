package com.tarzen.cavelooter.service;

import com.tarzen.cavelooter.entity.Game;

public interface GameService {

	void saveGame(Game game,boolean isPausedGame);
	
	void viewAllGames();
	
	Game loadLastPlayedGame();
}
