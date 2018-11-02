package com.tarzen.cavelooter.menu.navigator.service.impl;

import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.menu.navigator.service.WelcomeMenuActionsService;
import com.tarzen.cavelooter.service.BarrierService;
import com.tarzen.cavelooter.service.GameActionsService;
import com.tarzen.cavelooter.service.GameService;
import com.tarzen.cavelooter.service.PlayerService;
import com.tarzen.cavelooter.service.impl.BarrierServiceImpl;
import com.tarzen.cavelooter.service.impl.GameActionsServiceImpl;
import com.tarzen.cavelooter.service.impl.GameServiceImpl;
import com.tarzen.cavelooter.service.impl.PlayerServiceImpl;
import com.tarzen.cavelooter.util.UserInputReader;

/**
 * 
 * Service class which handles welcome menu features and propagates to next step
 * to realize the implementation.
 * 
 */
public class WelcomeMenuActionsServiceImpl implements WelcomeMenuActionsService {

	private GameActionsService gameManuService = new GameActionsServiceImpl();

	private PlayerService playerService = new PlayerServiceImpl();

	private GameService gameService = new GameServiceImpl();

	private BarrierService barrierService = new BarrierServiceImpl();

	/**
	 * loads last played game with all details.
	 */
	@Override
	public void resumeLastPlayedGame() {
		Game lastGame = gameService.loadLastPlayedGame();
		if (null != lastGame) {
			System.out.println("Loading your game...");
			System.out.println(lastGame);
			gameManuService.playGame(lastGame, true);
			secureGame(lastGame);
		}
	}

	/**
	 * Saves given state of Game.
	 */
	@Override
	public void secureGame(Game game) {
		boolean isPausedGame;
		if (game.isGameOver()) {
			isPausedGame = false;
		} else {
			isPausedGame = true;
		}
		gameService.saveGame(game, isPausedGame);

	}

	/**
	 * Organizes new game with player and barriers loaded in the cave.
	 */
	@Override
	public void organizeNewGame() {
		System.out.println("Organizing your game...");
		Game game = new Game();
		playerService.arrangePlayerForGame(game);
		if (null != game.getPlayer()) {
			barrierService.organizeBarriers(game);
			System.out.println("Barrier loaded of capacity :" + game.getCurrentBarrier().getCapacity());
			gameManuService.playGame(game, false);
			secureGame(game);
		}
	}

	/**
	 * Gets user inputs to create player profile.
	 * @return
	 */
	public Player getPlayerDetails() {
		Player player = new Player();
		System.out.println("Player Id:");
		player.setPlayerId(UserInputReader.readStringInput());
		System.out.println("Player Name:");
		player.setPlayerName(UserInputReader.readStringInput());
		System.out.println("Country:");
		player.setCountry(UserInputReader.readStringInput());
		getPlayerPower(player);
		return player;
	}

	/**
	 * takes valid user input for player's power.
	 * @param player
	 */
	private void getPlayerPower(Player player) {
		int userInput = 0;
		while (userInput == 0) {
			System.out.println("Power:");
			userInput = UserInputReader.readInput();
		}
		player.setPower(userInput);
	}

	/**
	 * Saves players profile.
	 */
	@Override
	public void createPlayerProfile() {
		Player player = getPlayerDetails();
		playerService.savePlayerProfile(player);
	}

	/**
	 * View all player profiles.
	 */
	@Override
	public void viewAllPlayers() {
		playerService.viewAllPlayers();
	}

	/**
	 * View game history
	 */
	@Override
	public void viewGameHistory() {
		gameService.viewAllGames();

	}

}
