package com.tarzen.cavelooter.factory;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.dao.BarrierDao;
import com.tarzen.cavelooter.dao.GameDao;
import com.tarzen.cavelooter.dao.PlayerDao;
import com.tarzen.cavelooter.dao.impl.BarrierDaoImpl;
import com.tarzen.cavelooter.dao.impl.GameDaoImpl;
import com.tarzen.cavelooter.dao.impl.PlayerDaoImpl;

/**
 * 
 * Responsible to create and return object of requested Dao class.
 */
public class GameDaoObjectFactory {

	private static GameDao gameDao;
	private static PlayerDao playerDao;
	private static BarrierDao barrierDao;

	private GameDaoObjectFactory() {

	}

	public static Object getDaoObject(String clazName) {
		if (Constants.GAME.equalsIgnoreCase(clazName)) {
			gameDao = gameDao != null ? gameDao : new GameDaoImpl();
			return gameDao;
		} else if (Constants.PLAYER.equalsIgnoreCase(clazName)) {
			playerDao = playerDao != null ? playerDao : new PlayerDaoImpl();
			return playerDao;
		} else if (Constants.BARRIER.equalsIgnoreCase(clazName)) {
			barrierDao = barrierDao != null ? barrierDao : new BarrierDaoImpl();
			return barrierDao;
		}
		return null;
	}
}
