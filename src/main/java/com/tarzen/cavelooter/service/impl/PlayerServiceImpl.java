package com.tarzen.cavelooter.service.impl;

import java.util.Map;

import com.tarzen.cavelooter.dao.PlayerDao;
import com.tarzen.cavelooter.dao.impl.PlayerDaoImpl;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.exceptions.PlayerNotFoundException;
import com.tarzen.cavelooter.exceptions.PlayerProfileAlreadyExistsException;
import com.tarzen.cavelooter.service.PlayerService;
import com.tarzen.cavelooter.util.UserInputReader;

/**
 * Responsible to handle all player related operations.
 *
 */
public class PlayerServiceImpl implements PlayerService {

	private PlayerDao playerDao = new PlayerDaoImpl();

	@Override
	public void savePlayerProfile(Player player) {
		try {
			playerDao.savePlayerProfile(player);
			System.out.println("Profile created!");
		} catch (PlayerProfileAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void viewAllPlayers() {
		Map<String, Player> players;
		try {
			players = playerDao.getAllPlayers();
			showPlayers(players);
		} catch (PlayerNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void showPlayers(Map<String, Player> players) {
		players.entrySet().forEach(entry -> {
			Player player = entry.getValue();
			System.out.println(player);
		});
	}
	
	@Override
	public void arrangePlayerForGame(Game game) {
		Map<String, Player> players;
		Player player;
		try {
			players = playerDao.getAllPlayers();
			if (players.size() > 1) {
				System.out.println("Multiple player profiles found :");
				showPlayers(players);
				System.out.println("Please select playerId for your game::");
				String playerId = UserInputReader.readStringInput();
				playerDao.getPlayerById(playerId);

				player = new Player(playerDao.getPlayerById(playerId));
				game.setPlayer(player);
			} else {
				player = new Player(players.entrySet().iterator().next().getValue());
				game.setPlayer(player);
			}
		} catch (PlayerNotFoundException e) {
			System.out.println(e.getMessage());
			arrangePlayerForGame(game);
		}
	}
}