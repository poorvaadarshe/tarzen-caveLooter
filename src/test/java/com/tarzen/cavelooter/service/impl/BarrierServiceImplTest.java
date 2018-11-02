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

import com.tarzen.cavelooter.dao.BarrierDao;
import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.factory.TarzenPersistanceFactory;
import com.tarzen.cavelooter.service.impl.BarrierServiceImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TarzenPersistanceFactory.class)
public class BarrierServiceImplTest {

	@InjectMocks
	BarrierServiceImpl barrierServiceImpl;

	@Mock
	BarrierDao barrierDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		PowerMockito.mockStatic(TarzenPersistanceFactory.class);
		Mockito.when(TarzenPersistanceFactory.getService("barrier")).thenReturn(barrierDao);
	}

	@Test
	public void organizeBarriers() {
		barrierServiceImpl.organizeBarriers(formGameObject());
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
