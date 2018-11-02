package com.tarzen.cavelooter.service;

import com.tarzen.cavelooter.entity.Game;

@FunctionalInterface
public interface GameRefereeService {
	public void updateGameOnAction(Game game, int powerToReduce);
}
