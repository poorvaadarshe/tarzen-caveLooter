package com.tarzen.cavelooter.service;

import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;

public interface PlayerService {

	void savePlayerProfile(Player player);
	
	void viewAllPlayers();
	
	void arrangePlayerForGame(Game game);

}
