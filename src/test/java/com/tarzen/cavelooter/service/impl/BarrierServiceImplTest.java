package com.tarzen.cavelooter.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.tarzen.cavelooter.constants.Constants;
import com.tarzen.cavelooter.dao.BarrierDao;
import com.tarzen.cavelooter.factory.TarzenPersistanceFactory;
import com.tarzen.cavelooter.model.DataCreationHelper;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TarzenPersistanceFactory.class)
public class BarrierServiceImplTest {

	@InjectMocks
	BarrierServiceImpl barrierServiceImpl;

	@Mock
	BarrierDao barrierDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		PowerMockito.mockStatic(TarzenPersistanceFactory.class);
		Mockito.when(TarzenPersistanceFactory.getDaoObject(Constants.BARRIER)).thenReturn(barrierDao);
	}

	@Test
	public void organizeBarriers() {
		barrierServiceImpl.organizeBarriers(DataCreationHelper.createGameModel());
	}

	}
