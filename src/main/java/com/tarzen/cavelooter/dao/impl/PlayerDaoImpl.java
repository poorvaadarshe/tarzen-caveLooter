package com.tarzen.cavelooter.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.tarzen.cavelooter.dao.PlayerDao;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.exceptions.PlayerNotFoundException;
import com.tarzen.cavelooter.exceptions.PlayerProfileAlreadyExistsException;

/**
 * Repository
 * Responsible to hold player data and perform basic and necessary 
 * CRUD operations for the application.
 *
 */
public class PlayerDaoImpl implements PlayerDao {

	private final Map<String, Player> playerProfiles = new HashMap<>();

	@Override
	public void savePlayerProfile(Player player) throws PlayerProfileAlreadyExistsException {
		if (!playerProfiles.containsKey(player.getPlayerId())) {
			playerProfiles.put(player.getPlayerId(), player);
		} else {
			throw new PlayerProfileAlreadyExistsException("Player profile already exists.");
		}
	}

	@Override
	public Player getPlayerById(String playerId) throws PlayerNotFoundException {
		Player player = playerProfiles.get(playerId);
		if (null != player) {
			return player;
		} else {
			throw new PlayerNotFoundException("No player with such playerId exists.");
		}
	}

	@Override
	public Map<String, Player> getAllPlayers() throws PlayerNotFoundException {
		if (!playerProfiles.isEmpty()) {
			return playerProfiles;
		} else {
			throw new PlayerNotFoundException("Oops! No players found. Please create a player profile first.");
		}
	}

}
