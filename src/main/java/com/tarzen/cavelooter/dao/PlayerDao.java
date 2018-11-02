package com.tarzen.cavelooter.dao;

import java.util.Map;

import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.exceptions.PlayerNotFoundException;
import com.tarzen.cavelooter.exceptions.PlayerProfileAlreadyExistsException;

public interface PlayerDao {

	void savePlayerProfile(Player player) throws PlayerProfileAlreadyExistsException;
	
	Player getPlayerById(String playerId) throws PlayerNotFoundException;
	
	Map<String,Player> getAllPlayers() throws PlayerNotFoundException;
}
