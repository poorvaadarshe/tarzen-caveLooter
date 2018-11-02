package com.tarzen.cavelooter.factory;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.service.impl.BarrierServiceImpl;
import com.tarzen.cavelooter.service.impl.GameActionsServiceImpl;
import com.tarzen.cavelooter.service.impl.GameRefereeServiceImpl;
import com.tarzen.cavelooter.service.impl.GameServiceImpl;
import com.tarzen.cavelooter.service.impl.PlayerServiceImpl;

/**
 * Responsible to create and return object of requested service class.
 * 
 */
public class TarzenServiceFactory {

	private TarzenServiceFactory() {

	}

	public static Object getServiceObject(String serviceName) {
		if (Constants.GAME.equalsIgnoreCase(serviceName)) {
			return new GameServiceImpl();
		} else if (Constants.PLAYER.equalsIgnoreCase(serviceName)) {
			return new PlayerServiceImpl();
		} else if (Constants.BARRIER.equalsIgnoreCase(serviceName)) {
			return new BarrierServiceImpl();
		} else if (Constants.GAME_ACTION.equalsIgnoreCase(serviceName)) {
			return new GameActionsServiceImpl();
		} else if (Constants.GAME_REFEREE.equalsIgnoreCase(serviceName)) {
			return new GameRefereeServiceImpl();
		}
		return null;
	}

}
