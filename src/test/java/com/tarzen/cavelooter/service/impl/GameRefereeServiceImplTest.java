package com.tarzen.cavelooter.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.tarzen.cavelooter.model.DataCreationHelper;

public class GameRefereeServiceImplTest {

	@InjectMocks
	GameRefereeServiceImpl gameRefereeServiceImpl;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void updateGameOnAction(){
		gameRefereeServiceImpl.updateGameOnAction(DataCreationHelper.createGameModel(), 300);
	}
	
	
}
