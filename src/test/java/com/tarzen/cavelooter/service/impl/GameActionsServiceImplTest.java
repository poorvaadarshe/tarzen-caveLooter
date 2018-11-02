package com.tarzen.cavelooter.service.impl;

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
import com.tarzen.cavelooter.service.GameRefereeService;
import com.tarzen.cavelooter.service.impl.GameActionsServiceImpl;
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
		PowerMockito.mockStatic(UserInputReader.class);
		Mockito.when(TarzenServiceFactory.getService("GameReferee")).thenReturn(gameRefereeService);
		gameActionsServiceImpl.playGame(formGameObject(), true);
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
