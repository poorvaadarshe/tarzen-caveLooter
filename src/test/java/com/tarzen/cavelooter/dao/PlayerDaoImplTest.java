package com.tarzen.cavelooter.dao;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.tarzen.cavelooter.dao.impl.PlayerDaoImpl;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.exceptions.PlayerNotFoundException;
import com.tarzen.cavelooter.exceptions.PlayerProfileAlreadyExistsException;

public class PlayerDaoImplTest {

	@InjectMocks
	PlayerDaoImpl playerDaoImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void savePlayerProfileTest() throws PlayerProfileAlreadyExistsException {
		playerDaoImpl.savePlayerProfile(createPlayerDetails());
	}

	@Test(expected = PlayerProfileAlreadyExistsException.class)
	public void savePlayerProfileExceptionTest() throws PlayerProfileAlreadyExistsException {
		savePlayerProfileTest();
		playerDaoImpl.savePlayerProfile(createPlayerDetails());
	}

	@Test
	public void getPlayerTest() throws PlayerNotFoundException, PlayerProfileAlreadyExistsException {
		savePlayerProfileTest();
		Player player=playerDaoImpl.getPlayerById("1");
		Assert.assertEquals("Jame", player.getPlayerName());
	}
	
	@Test(expected=PlayerNotFoundException.class)
	public void getPlayerTestException() throws PlayerNotFoundException, PlayerProfileAlreadyExistsException {
		savePlayerProfileTest();
		playerDaoImpl.getPlayerById("3");
	}
	
	@Test
	public void getAllPlayersTest() throws PlayerNotFoundException, PlayerProfileAlreadyExistsException {
		savePlayerProfileTest();
		 Map<String, Player> map=playerDaoImpl.getAllPlayers();
		 Assert.assertEquals(1,map.size());
	}
	
	@Test(expected=PlayerNotFoundException.class)
	public void getAllPlayersTestException() throws PlayerNotFoundException {
		playerDaoImpl.getAllPlayers();
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
}
