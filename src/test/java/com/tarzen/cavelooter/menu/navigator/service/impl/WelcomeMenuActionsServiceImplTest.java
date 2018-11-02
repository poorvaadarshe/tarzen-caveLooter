package com.tarzen.cavelooter.menu.navigator.service.impl;

import java.util.HashMap;
import java.util.Map;

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

import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.factory.TarzenServiceFactory;
import com.tarzen.cavelooter.menu.navigator.service.impl.WelcomeMenuActionsServiceImpl;
import com.tarzen.cavelooter.service.BarrierService;
import com.tarzen.cavelooter.service.GameActionsService;
import com.tarzen.cavelooter.service.GameService;
import com.tarzen.cavelooter.service.PlayerService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TarzenServiceFactory.class)
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
		PowerMockito.mockStatic(TarzenServiceFactory.class);
		Mockito.when(TarzenServiceFactory.getService("game")).thenReturn(gameService);
		Mockito.when(TarzenServiceFactory.getService("gameAction")).thenReturn(gameActionsService);
		Mockito.when(TarzenServiceFactory.getService("barrier")).thenReturn(barrierService);
		Mockito.when(TarzenServiceFactory.getService("player")).thenReturn(playerService);

	}

	@Test
	public void resumeLastPlayedGame() {
		Mockito.when(TarzenServiceFactory.getService("game")).thenReturn(gameService);
		Mockito.when(gameService.loadLastPlayedGame()).thenReturn(formGameObject());
		welcomeMenuActionsServiceImpl.resumeLastPlayedGame();
	}

	@Test
	public void secureGame(){
		welcomeMenuActionsServiceImpl.secureGame(formGameObject());
	}
	
	@Test
	public void organizeNewGame(){
		welcomeMenuActionsServiceImpl.organizeNewGame();
	}
	private Game formGameObject() {
		Game game = new Game();
		Map<Integer, Barrier> barrierMap = new HashMap<>();
		barrierMap.put(1, createBarrier());
		game.setBarrierMap(barrierMap);
		game.setCurrentBarrier(createBarrier());
		game.setPlayer(createPlayerDetails());
		return game;
	}

	private Player createPlayerDetails() {
		Player player = new Player();
		player.setCountry("India");
		player.setPlayerId("1");
		player.setPlayerName("Jame");
		player.setPower(400);
		player.setTotalLoot(240);
		return player;
	}

	private Barrier createBarrier() {
		Barrier barrier = new Barrier();
		barrier.setBarrierNumber(1);
		barrier.setBonus(100);
		barrier.setCapacity(300);
		return barrier;
	}
}
