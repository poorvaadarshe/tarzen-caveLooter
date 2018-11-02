package com.tarzen.cavelooter.dao;

import java.util.Map;

import com.tarzen.cavelooter.entity.Barrier;

public interface BarrierDao {

	Barrier getBarrier(int barrierNumber);
	
	Map<Integer,Barrier> loadBarriers();
}
