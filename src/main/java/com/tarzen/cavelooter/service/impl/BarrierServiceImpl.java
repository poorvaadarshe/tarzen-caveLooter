package com.tarzen.cavelooter.service.impl;

import java.util.Map;

import com.tarzen.cavelooter.dao.BarrierDao;
import com.tarzen.cavelooter.dao.impl.BarrierDaoImpl;
import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.service.BarrierService;

public class BarrierServiceImpl implements BarrierService {

	private BarrierDao barrierDao = new BarrierDaoImpl();
	
	@Override
	public void organizeBarriers(Game game) {
		Map<Integer,Barrier> barriers = barrierDao.loadBarriers();
		game.setBarrierMap(barriers);
		game.setCurrentBarrier(barriers.get(1));
	}
}