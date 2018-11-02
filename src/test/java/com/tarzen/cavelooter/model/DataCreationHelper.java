package com.tarzen.cavelooter.model;

import java.util.HashMap;
import java.util.Map;

import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;

public class DataCreationHelper {
	
public static Game createGameModel() {
		Game game = new Game();
		Map<Integer, Barrier> barrierMap = new HashMap<>();
		barrierMap.put(1, createBarrier());
		game.setBarrierMap(barrierMap);
		game.setCurrentBarrier(createBarrier());
		game.setPlayer(createPlayerDetails());
		game.setGameOver(true);
		return game;
}


public static Player createPlayerDetails() {
		Player player = new Player();
		player.setCountry("India");
		player.setPlayerId("1");
		player.setPlayerName("Jame");
		player.setPower(400);
		player.setTotalLoot(240);
		return player;
	}


public static Barrier createBarrier() {
		Barrier barrier = new Barrier();
		barrier.setBarrierNumber(1);
		barrier.setBonus(100);
		barrier.setCapacity(300);
		return barrier;
	}
}
