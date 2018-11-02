package com.tarzen.cavelooter.factory;

import com.tarzen.cavelooter.service.impl.BarrierServiceImpl;
import com.tarzen.cavelooter.service.impl.GameActionsServiceImpl;
import com.tarzen.cavelooter.service.impl.GameRefereeServiceImpl;
import com.tarzen.cavelooter.service.impl.GameServiceImpl;
import com.tarzen.cavelooter.service.impl.PlayerServiceImpl;

/**
 * This are factory class used to created the services
 * 
 * @author
 *
 */
public class TarzenServiceFactory {

	private TarzenServiceFactory() {

	}

	public static Object getService(String str) {
		if (str.equals("game")) {
			return new GameServiceImpl();
		} else if (str.equals("player")) {
			return new PlayerServiceImpl();
		} else if (str.equals("barrier")) {
			return new BarrierServiceImpl();
		} else if (str.equals("gameAction")) {
			return new GameActionsServiceImpl();
		} else if (str.equals("GameReferee")) {
			return new GameRefereeServiceImpl();
		}
		return null;
	}

}
