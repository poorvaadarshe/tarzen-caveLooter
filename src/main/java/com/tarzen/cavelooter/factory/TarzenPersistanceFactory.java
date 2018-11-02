package com.tarzen.cavelooter.factory;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.dao.impl.BarrierDaoImpl;
import com.tarzen.cavelooter.dao.impl.GameDaoImpl;
import com.tarzen.cavelooter.dao.impl.PlayerDaoImpl;

/**
 * 
 * Responsible to create and return object of requested Dao class.
 */
public class TarzenPersistanceFactory {

	private TarzenPersistanceFactory() {

	}

	public static Object getDaoObject(String serviceName) {
		if (Constants.GAME.equalsIgnoreCase(serviceName)){
				return new GameDaoImpl();
		} else if (Constants.PLAYER.equalsIgnoreCase(serviceName)) {
				return new PlayerDaoImpl();
		} else if (Constants.BARRIER.equalsIgnoreCase(serviceName)) {
				return new BarrierDaoImpl();
		}
		return null;
	}
}
