package com.tarzen.cavelooter.factory;

import com.tarzen.cavelooter.dao.impl.BarrierDaoImpl;
import com.tarzen.cavelooter.dao.impl.GameDaoImpl;
import com.tarzen.cavelooter.dao.impl.PlayerDaoImpl;

public class TarzenPersistanceFactory {
	
	private TarzenPersistanceFactory() {

	}

	public static Object getService(String str) {
		if (str.equals("game")) {
			return new GameDaoImpl();
		} else if (str.equals("player")) {
			return new PlayerDaoImpl();
		} else if (str.equals("barrier")) {
			return new BarrierDaoImpl();
		} 
		return null;
	}
}
