package com.tarzen.cavelooter.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.tarzen.cavelooter.dao.impl.PlayerDaoImpl;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.exceptions.PlayerNotFoundException;
import com.tarzen.cavelooter.exceptions.PlayerProfileAlreadyExistsException;
import com.tarzen.cavelooter.model.DataCreationHelper;

public class PlayerDaoImplTest {

	@InjectMocks
	PlayerDaoImpl playerDaoImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void savePlayerProfileTest() throws PlayerProfileAlreadyExistsException {
		playerDaoImpl.savePlayerProfile(DataCreationHelper.createPlayerDetails());
	}

	@Test(expected = PlayerProfileAlreadyExistsException.class)
	public void savePlayerProfileExceptionTest() throws PlayerProfileAlreadyExistsException {
		playerDaoImpl.savePlayerProfile(DataCreationHelper.createPlayerDetails());
	}

	@Test
	public void getPlayerTest() throws PlayerNotFoundException, PlayerProfileAlreadyExistsException {
		Player player = playerDaoImpl.getPlayerById("1");
		Assert.assertEquals("Jame", player.getPlayerName());
	}

	@Test(expected = PlayerNotFoundException.class)
	public void getPlayerTestException() throws PlayerNotFoundException, PlayerProfileAlreadyExistsException {
		playerDaoImpl.getPlayerById("3");
	}

	@Test
	public void getAllPlayersTest() throws PlayerNotFoundException, PlayerProfileAlreadyExistsException {
		playerDaoImpl.savePlayerProfile(DataCreationHelper.createPlayerDetails());
		Assert.assertNotNull(playerDaoImpl.getAllPlayers());
	}

	@Test(expected = PlayerNotFoundException.class)
	public void getAllPlayersTestException() throws PlayerNotFoundException {
		playerDaoImpl.getAllPlayers().clear();
		playerDaoImpl.getAllPlayers();
	}
}
