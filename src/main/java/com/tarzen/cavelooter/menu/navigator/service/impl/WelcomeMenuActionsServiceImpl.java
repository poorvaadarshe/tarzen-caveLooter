package com.tarzen.cavelooter.menu.navigator.service.impl;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.factory.TarzenServiceFactory;
import com.tarzen.cavelooter.menu.navigator.service.WelcomeMenuActionsService;
import com.tarzen.cavelooter.service.BarrierService;
import com.tarzen.cavelooter.service.GameActionsService;
import com.tarzen.cavelooter.service.GameService;
import com.tarzen.cavelooter.service.PlayerService;
import com.tarzen.cavelooter.util.UserInputReader;

/**
 * 
 * Service class which handles welcome menu features and propagates to next step
 * to realize the implementation.
 * 
 */
public class WelcomeMenuActionsServiceImpl implements WelcomeMenuActionsService {

	/**
	 * loads last played game with all details.
	 */
	@Override
	public void resumeLastPlayedGame() {
		Game lastGame = getGameService().loadLastPlayedGame();
		if (null != lastGame) {
			System.out.println("Loading your game...");
			System.out.println(lastGame);
			getGameActionsService().playGame(lastGame, true);
			getGameService().completePausedGame();
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
		getGameService().saveGame(game, isPausedGame);

	}

	/**
	 * Organizes new game with player and barriers loaded in the cave.
	 */
	@Override
	public void organizeNewGame() {
		System.out.println("Organizing your game...");
		Game game = new Game();
		getPlayerService().arrangePlayerForGame(game);
		if (null != game.getPlayer()) {
			getBarrierService().organizeBarriers(game);
			System.out.println("Barrier loaded of capacity :" + game.getCurrentBarrier().getCapacity());
			getGameActionsService().playGame(game, false);
			secureGame(game);
		}
	}

	/**
	 * Gets user inputs to create player profile.
	 * 
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
	 * 
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
		getPlayerService().savePlayerProfile(player);
	}

	/**
	 * View all player profiles.
	 */
	@Override
	public void viewAllPlayers() {
		getPlayerService().viewAllPlayers();
	}

	/**
	 * View game history
	 */
	@Override
	public void viewGameHistory() {
		getGameService().viewAllGames();

	}

	private GameActionsService getGameActionsService() {
		return (GameActionsService) TarzenServiceFactory.getServiceObject(Constants.GAME_ACTION);
	}

	private PlayerService getPlayerService() {
		return (PlayerService) TarzenServiceFactory.getServiceObject(Constants.PLAYER);
	}

	private GameService getGameService() {
		return (GameService) TarzenServiceFactory.getServiceObject(Constants.GAME);
	}

	private BarrierService getBarrierService() {
		return (BarrierService) TarzenServiceFactory.getServiceObject(Constants.BARRIER);
	}

}
