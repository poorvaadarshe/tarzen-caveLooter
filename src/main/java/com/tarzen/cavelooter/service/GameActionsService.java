package com.tarzen.cavelooter.service;

import com.tarzen.cavelooter.entity.Game;

@FunctionalInterface
public interface GameActionsService {

	void playGame(Game game, boolean isResumedGame);

}
