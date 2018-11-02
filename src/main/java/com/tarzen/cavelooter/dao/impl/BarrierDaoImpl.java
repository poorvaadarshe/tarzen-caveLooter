package com.tarzen.cavelooter.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.tarzen.cavelooter.dao.BarrierDao;
import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.util.RandomPropertiesGeneratorUtil;

public class BarrierDaoImpl implements BarrierDao {

	private final Map<Integer,Barrier> barriers = new HashMap<>();
	
	@Override
	public Barrier getBarrier(int barrierNumber) {
		return barriers.get(barrierNumber);
	}

	@Override
	public final Map<Integer,Barrier> loadBarriers() {
		barriers.put(1, new Barrier(1, RandomPropertiesGeneratorUtil.loadBarriersCapacity(90, 30), RandomPropertiesGeneratorUtil.loadBonus()));
		barriers.put(2, new Barrier(2, RandomPropertiesGeneratorUtil.loadBarriersCapacity(140, 29), RandomPropertiesGeneratorUtil.loadBonus()));
		barriers.put(3, new Barrier(3, RandomPropertiesGeneratorUtil.loadBarriersCapacity(190, 22), RandomPropertiesGeneratorUtil.loadBonus()));
		return barriers;
	}
	
	
}
