package com.tarzen.cavelooter.service.impl;

import java.util.List;

import com.tarzen.cavelooter.dao.GameDao;
import com.tarzen.cavelooter.dao.impl.GameDaoImpl;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.exceptions.GamesNotFoundException;
import com.tarzen.cavelooter.service.GameService;

/**
 * This class is responsible to handle Game based operations like saving current state of game,
 * showAllGames and to load last paused game by user.
 *
 */
public class GameServiceImpl implements GameService {

	private GameDao gameDao = new GameDaoImpl();

	@Override
	public void saveGame(Game game, boolean isPausedGame) {
		gameDao.saveGame(game, isPausedGame);
	}

	@Override
	public void viewAllGames() {
		try {
			List<Game> games = gameDao.getAllGames();
			games.forEach(game -> {
				System.out.println(game);
			});
		} catch (GamesNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Game loadLastPlayedGame() {
		Game game = null;
		try {
			game = gameDao.getPausedGame();
		} catch (GamesNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return game;
	}

}
