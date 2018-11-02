package com.tarzen.cavelooter.service.impl;

import java.util.Map;

import com.tarzen.cavelooter.dao.PlayerDao;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.exceptions.PlayerNotFoundException;
import com.tarzen.cavelooter.exceptions.PlayerProfileAlreadyExistsException;
import com.tarzen.cavelooter.factory.TarzenPersistanceFactory;
import com.tarzen.cavelooter.service.PlayerService;
import com.tarzen.cavelooter.util.UserInputReader;

/**
 * Responsible to handle all player related operations.
 *
 */
public class PlayerServiceImpl implements PlayerService {


	@Override
	public void savePlayerProfile(Player player) {
		try {
			getPlayerDao().savePlayerProfile(player);
			System.out.println("Profile created!");
		} catch (PlayerProfileAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void viewAllPlayers() {
		Map<String, Player> players;
		try {
			players = getPlayerDao().getAllPlayers();
			showPlayers(players);
		} catch (PlayerNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void showPlayers(Map<String, Player> players) {
		players.entrySet().forEach(entry -> {
			System.out.println(entry.getValue());
		});
	}
	
	@Override
	public void arrangePlayerForGame(Game game) {
		Map<String, Player> players;
		Player player;
		boolean isInvalidPlayerIdChosen = false;
		try {
			players = getPlayerDao().getAllPlayers();
			if (players.size() > 1) {
				System.out.println("Multiple player profiles found :");
				showPlayers(players);
				System.out.println("Please select playerId for your game::");
				String playerId = UserInputReader.readStringInput();
				getPlayerDao().getPlayerById(playerId);
				isInvalidPlayerIdChosen = true;
				player = new Player(getPlayerDao().getPlayerById(playerId));
				game.setPlayer(player);
			} else {
				player = new Player(players.entrySet().stream().findFirst().get().getValue());
				game.setPlayer(player);
			}
		} catch (PlayerNotFoundException e) {
			System.out.println(e.getMessage());
			if(isInvalidPlayerIdChosen) {
				arrangePlayerForGame(game);
			}
		}
	}

	private PlayerDao getPlayerDao() {
		return (PlayerDao) TarzenPersistanceFactory.getService("player");
	}
	
	
}