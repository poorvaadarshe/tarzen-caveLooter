package com.tarzen.cavelooter.service.impl;

import java.util.Map;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.dao.BarrierDao;
import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.factory.TarzenPersistanceFactory;
import com.tarzen.cavelooter.service.BarrierService;

/**
 * This class responsible to load and initialize barriers in the Game
 *
 */
public class BarrierServiceImpl implements BarrierService {

	@Override
	public void organizeBarriers(Game game) {
		Map<Integer, Barrier> barriers = getBarrierDao().loadBarriers();
		game.setBarrierMap(barriers);
		game.setCurrentBarrier(barriers.get(1));
	}

	private BarrierDao getBarrierDao() {
		return (BarrierDao) TarzenPersistanceFactory.getDaoObject(Constants.BARRIER);
	}
}