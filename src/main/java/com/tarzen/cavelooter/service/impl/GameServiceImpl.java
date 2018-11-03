package com.tarzen.cavelooter.service.impl;

import java.util.List;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.dao.GameDao;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.exceptions.GamesNotFoundException;
import com.tarzen.cavelooter.factory.TarzenPersistanceFactory;
import com.tarzen.cavelooter.service.GameService;

/**
 * This class is responsible to handle Game based operations like saving current
 * state of game, showAllGames and to load last paused game by user.
 *
 */
public class GameServiceImpl implements GameService {

	@Override
	public void saveGame(Game game, boolean isPausedGame) {
		getGameDao().saveGame(game, isPausedGame);
	}

	@Override
	public void viewAllGames() {
		try {
			List<Game> games = getGameDao().getAllGames();
			games.forEach(game -> {
				readGameStatus(game);
			});
		} catch (GamesNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void readGameStatus(Game game) {
		Player player = game.getPlayer();
		if (game.isGameOver()) {
			System.out.println(player.getPlayerName() + "(" + player.getCountry()
					+ ") has completed the loot grabbing $" + player.getTotalLoot());
		} else {
			System.out.println(player.getPlayerName() + "(" + player.getCountry() + ") has crossed "
					+ (game.getCurrentBarrier().getBarrierNumber() - 1) + " barriers, looted $" + player.getTotalLoot()
					+ " and remaining power is " + player.getPower() + " Current barrier's capacity is : "
					+ game.getCurrentBarrier().getCapacity());
		}
	}

	@Override
	public Game loadLastPlayedGame() {
		Game game = null;
		try {
			game = getGameDao().getPausedGame();
		} catch (GamesNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return game;
	}
	

	@Override
	public void completePausedGame() {
		getGameDao().resetPausedGameOnGameOver();
	}

	private GameDao getGameDao() {
		return (GameDao) TarzenPersistanceFactory.getDaoObject(Constants.GAME);
	}


}
