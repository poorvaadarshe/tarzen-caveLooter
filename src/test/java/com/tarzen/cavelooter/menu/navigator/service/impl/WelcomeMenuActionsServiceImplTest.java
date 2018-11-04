package com.tarzen.cavelooter.menu.navigator.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.factory.GameServiceObjectFactory;
import com.tarzen.cavelooter.model.DataCreationHelper;
import com.tarzen.cavelooter.service.BarrierService;
import com.tarzen.cavelooter.service.GameActionsService;
import com.tarzen.cavelooter.service.GameService;
import com.tarzen.cavelooter.service.PlayerService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GameServiceObjectFactory.class)
public class WelcomeMenuActionsServiceImplTest {

	@InjectMocks
	WelcomeMenuActionsServiceImpl welcomeMenuActionsServiceImpl;

	@Mock
	GameService gameService;

	@Mock
	GameActionsService gameActionsService;

	@Mock
	BarrierService barrierService;

	@Mock
	PlayerService playerService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		PowerMockito.mockStatic(GameServiceObjectFactory.class);
	}

	@Test
	public void resumeLastPlayedGame() {
		Mockito.when(GameServiceObjectFactory.getServiceObject(Constants.GAME)).thenReturn(gameService);
		Mockito.when(gameService.loadLastPlayedGame()).thenReturn(DataCreationHelper.createGameModel());
		Mockito.when(GameServiceObjectFactory.getServiceObject(Constants.GAME_ACTION)).thenReturn(gameActionsService);
		welcomeMenuActionsServiceImpl.resumeLastPlayedGame();
	}

	@Test
	public void secureGame() {
		Mockito.when(GameServiceObjectFactory.getServiceObject(Constants.GAME)).thenReturn(gameService);
		Mockito.doNothing().when(gameService).saveGame(Mockito.isA(Game.class), Mockito.anyBoolean());
		welcomeMenuActionsServiceImpl.secureGame(DataCreationHelper.createGameModel());
	}

	@Test
	public void organizeNewGame() {
		Mockito.when(GameServiceObjectFactory.getServiceObject(Constants.GAME)).thenReturn(gameService);
		Mockito.when(GameServiceObjectFactory.getServiceObject(Constants.GAME_ACTION)).thenReturn(gameActionsService);
		Mockito.when(GameServiceObjectFactory.getServiceObject(Constants.BARRIER)).thenReturn(barrierService);
		Mockito.when(GameServiceObjectFactory.getServiceObject(Constants.PLAYER)).thenReturn(playerService);
		Mockito.doNothing().when(playerService).arrangePlayerForGame(Mockito.isA(Game.class));
		welcomeMenuActionsServiceImpl.organizeNewGame();
	}

}
