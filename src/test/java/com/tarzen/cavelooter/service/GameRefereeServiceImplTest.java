package com.tarzen.cavelooter.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.service.impl.GameRefereeServiceImpl;

public class GameRefereeServiceImplTest {

	@InjectMocks
	GameRefereeServiceImpl gameRefereeServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void updateGameOnAction() {
		gameRefereeServiceImpl.updateGameOnAction(formGameObject(), 100);
		gameRefereeServiceImpl.updateGameOnAction(formGameObject(), 5000);
	}
	private Game formGameObject() {
		Game game=new Game();
		Map<Integer,Barrier> barrierMap=new HashMap<>();
		barrierMap.put(1, createBarrier());
		game.setBarrierMap(barrierMap);
		game.setCurrentBarrier(createBarrier());
		game.setPlayer(createPlayerDetails());
		return game;
	}

	private Player createPlayerDetails() {
		Player player=new Player();
		player.setCountry("India");
		player.setPlayerId("1");
		player.setPlayerName("Jame");
		player.setPower(400);
		player.setTotalLoot(240);
		return player;
	}

	private Barrier createBarrier() {
		Barrier barrier=new Barrier();
		barrier.setBarrierNumber(1);
		barrier.setBonus(100);
		barrier.setCapacity(300);
		return barrier;
	}
}
