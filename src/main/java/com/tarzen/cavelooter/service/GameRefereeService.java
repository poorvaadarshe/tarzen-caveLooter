package com.tarzen.cavelooter.service;

import com.tarzen.cavelooter.entity.Game;

@FunctionalInterface
public interface GameRefereeService {
	void updateGameOnAction(Game game, int powerToReduce);
}
