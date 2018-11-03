package com.tarzen.cavelooter.dao;

import java.util.List;

import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.exceptions.GamesNotFoundException;

public interface GameDao {

	void saveGame(Game game,boolean isPausedGame);
	
	List<Game> getAllGames() throws GamesNotFoundException;
	
	Game getPausedGame() throws GamesNotFoundException;
	
	void resetPausedGameOnGameOver();
}
