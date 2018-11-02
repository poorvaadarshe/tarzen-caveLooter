package com.tarzen.cavelooter.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.tarzen.cavelooter.model.DataCreationHelper;
import com.tarzen.cavelooter.service.impl.GameRefereeServiceImpl;

public class GameRefereeServiceImplTest {

	@InjectMocks
	GameRefereeServiceImpl gameRefereeServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void updateGameOnAction() {
		gameRefereeServiceImpl.updateGameOnAction(DataCreationHelper.createGameModel(), 100);
		gameRefereeServiceImpl.updateGameOnAction(DataCreationHelper.createGameModel(), 5000);
	}
	
}
