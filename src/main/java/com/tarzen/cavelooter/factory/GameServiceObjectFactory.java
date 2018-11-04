package com.tarzen.cavelooter.factory;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.menu.navigator.service.WelcomeMenuActionsService;
import com.tarzen.cavelooter.menu.navigator.service.impl.WelcomeMenuActionsServiceImpl;
import com.tarzen.cavelooter.service.BarrierService;
import com.tarzen.cavelooter.service.GameActionsService;
import com.tarzen.cavelooter.service.GameRefereeService;
import com.tarzen.cavelooter.service.GameService;
import com.tarzen.cavelooter.service.PlayerService;
import com.tarzen.cavelooter.service.impl.BarrierServiceImpl;
import com.tarzen.cavelooter.service.impl.GameActionsServiceImpl;
import com.tarzen.cavelooter.service.impl.GameRefereeServiceImpl;
import com.tarzen.cavelooter.service.impl.GameServiceImpl;
import com.tarzen.cavelooter.service.impl.PlayerServiceImpl;

/**
 * Responsible to create and return object of requested service class.
 * 
 */
public class GameServiceObjectFactory {

	private static GameService gameService;
	private static PlayerService playerService;
	private static BarrierService barrierService;
	private static GameActionsService gameActionsService;
	private static WelcomeMenuActionsService welcomeActionsService;
	private static GameRefereeService gameRefereeService;

	private GameServiceObjectFactory() {

	}

	public static Object getServiceObject(String serviceName) {
		if (Constants.GAME.equalsIgnoreCase(serviceName)) {
			 gameService = gameService != null ? gameService : new GameServiceImpl();
			 return gameService;
		} else if (Constants.PLAYER.equalsIgnoreCase(serviceName)) {
			playerService = playerService != null ? playerService : new PlayerServiceImpl();
			return playerService;
		} else if (Constants.BARRIER.equalsIgnoreCase(serviceName)) {
			barrierService = barrierService != null ? barrierService : new BarrierServiceImpl();
			return barrierService;
		} else if (Constants.GAME_ACTION.equalsIgnoreCase(serviceName)) {
			gameActionsService = gameActionsService != null ? gameActionsService : new GameActionsServiceImpl();
			return gameActionsService;
		} else if (Constants.GAME_REFEREE.equalsIgnoreCase(serviceName)) {
			gameRefereeService = gameRefereeService != null ? gameRefereeService : new GameRefereeServiceImpl();
			return gameRefereeService;
		} else if (Constants.WELCOME_ACTIONS.equalsIgnoreCase(serviceName)) {
			welcomeActionsService = welcomeActionsService != null ? welcomeActionsService : new WelcomeMenuActionsServiceImpl();
			return welcomeActionsService;
		}
		return null;
	}

}
