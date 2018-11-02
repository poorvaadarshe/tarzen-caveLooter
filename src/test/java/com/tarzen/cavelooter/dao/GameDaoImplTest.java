package com.tarzen.cavelooter.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.tarzen.cavelooter.dao.impl.GameDaoImpl;
import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.exceptions.GamesNotFoundException;

public class GameDaoImplTest {

	@InjectMocks
	GameDaoImpl gameDaoImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSaveGameWithPausedGame() {
		Game game = formGameObject();
		gameDaoImpl.saveGame(game, true);
	}
	
	@Test
	public void testSaveGameWithoutPausedGame() {
		Game game = formGameObject();
		gameDaoImpl.saveGame(game, false);
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

	@Test(expected=GamesNotFoundException.class)
	public void testGetAllGamesException() throws GamesNotFoundException {
		gameDaoImpl.getAllGames();
	}
	
	@Test
	public void testGetAllGames() throws GamesNotFoundException {
		testSaveGameWithoutPausedGame();
		gameDaoImpl.getAllGames();
		Assert.assertEquals(1, gameDaoImpl.getAllGames().size());
	}

	@Test(expected=GamesNotFoundException.class)
	public void testGetPausedGameException() throws GamesNotFoundException {
		gameDaoImpl.getPausedGame();
	}
	
	@Test
	public void testGetPausedGame() throws GamesNotFoundException {
		testSaveGameWithPausedGame();
		gameDaoImpl.getPausedGame();
		Assert.assertEquals("Jame", gameDaoImpl.getPausedGame().getPlayer().getPlayerName());
	}
}
