package com.tarzen.cavelooter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tarzen.cavelooter.dao.GameDao;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.exceptions.GamesNotFoundException;

/**
 * This class is responsible to hold Games data and perform basic and necessary
 * CRUD operations for the application.
 * 
 */
public class GameDaoImpl implements GameDao {

	private List<Game> games = new ArrayList<>();
	private Game pausedGame;

	@Override
	public void saveGame(Game game, boolean isPausedGame) {
		if (isPausedGame) {
			pausedGame = game;
		} else {
			games.add(game);
		}
	}

	@Override
	public List<Game> getAllGames() throws GamesNotFoundException {
		if (!games.isEmpty()) {
			return games;
		} else {
			throw new GamesNotFoundException("No Games history found! Please finish your game to see in history.");
		}
	}

	@Override
	public Game getPausedGame() throws GamesNotFoundException {
		if (null != pausedGame) {
			return pausedGame;
		} else {
			throw new GamesNotFoundException("No Game paused yet.");
		}
	}
}