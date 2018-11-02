package com.tarzen.cavelooter.service;

import com.tarzen.cavelooter.entity.Game;

public interface GameActionsService {

	void playGame(Game game, boolean isResumedGame);

}
