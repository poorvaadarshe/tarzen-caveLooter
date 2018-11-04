package com.tarzen.cavelooter.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.tarzen.cavelooter.dao.impl.GameDaoImpl;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.exceptions.GamesNotFoundException;
import com.tarzen.cavelooter.model.DataCreationHelper;

public class GameDaoImplTest {

	@InjectMocks
	GameDaoImpl gameDaoImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveGameWithPausedGame() {
		Game game = DataCreationHelper.createGameModel();
		gameDaoImpl.saveGame(game, true);
	}

	@Test
	public void testSaveGameWithoutPausedGame() {
		Game game = DataCreationHelper.createGameModel();
		gameDaoImpl.saveGame(game, false);
	}

	@Test
	public void testGetPausedGame() throws GamesNotFoundException {
		Game game = DataCreationHelper.createGameModel();
		gameDaoImpl.saveGame(game, true);
		gameDaoImpl.getPausedGame();
		assertEquals("Jame", gameDaoImpl.getPausedGame().getPlayer().getPlayerName());
	}

	@Test
	public void testGetAllGames() throws GamesNotFoundException {
		List<Game> games = gameDaoImpl.getAllGames();
		assertNotNull(games);
	}

	@Test(expected = GamesNotFoundException.class)
	public void testGetAllGamesException() throws GamesNotFoundException {
		gameDaoImpl.getAllGames().clear();
		gameDaoImpl.getAllGames();
	}

	@Test(expected = GamesNotFoundException.class)
	public void testGetPausedGameException() throws GamesNotFoundException {
		gameDaoImpl.resetPausedGameOnGameOver();
		gameDaoImpl.getPausedGame();
	}

}
