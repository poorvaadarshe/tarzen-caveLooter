package com.tarzen.cavelooter.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.factory.TarzenServiceFactory;
import com.tarzen.cavelooter.model.DataCreationHelper;
import com.tarzen.cavelooter.service.GameRefereeService;
import com.tarzen.cavelooter.util.UserInputReader;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ TarzenServiceFactory.class, UserInputReader.class })
public class GameActionsServiceImplTest {

	@InjectMocks
	GameActionsServiceImpl gameActionsServiceImpl;

	@Mock
	GameRefereeService gameRefereeService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void playGame() {
		PowerMockito.mockStatic(TarzenServiceFactory.class);
		gameActionsServiceImpl.playGame(DataCreationHelper.createGameModel(), true);
	}

	@Test
	public void testPlayGame() {
		PowerMockito.mockStatic(TarzenServiceFactory.class);
		Game game = DataCreationHelper.createGameModel();
		game.getPlayer().setPower(-22);
		gameActionsServiceImpl.playGame(game, true);
	}
	
}
