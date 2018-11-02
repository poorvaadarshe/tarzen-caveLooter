package com.tarzen.cavelooter.dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.tarzen.cavelooter.dao.impl.BarrierDaoImpl;

public class BarrierDaoImplTest {
@InjectMocks
BarrierDaoImpl barrierDaoImpl;

@Before
public void setup() {
	MockitoAnnotations.initMocks(this);
}

@Test
public void loadBarriers() {
	barrierDaoImpl.loadBarriers();
}

@Test
public void getBarrier() {
	barrierDaoImpl.getBarrier(1);
}
}
