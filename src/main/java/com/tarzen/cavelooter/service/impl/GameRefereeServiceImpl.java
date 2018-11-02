/**
 * 
 */
package com.tarzen.cavelooter.service.impl;

import com.tarzen.cavelooter.entity.Barrier;
import com.tarzen.cavelooter.entity.Game;
import com.tarzen.cavelooter.entity.Player;
import com.tarzen.cavelooter.service.GameRefereeService;

/**
 * This class is responsible to handle entire business logic to update game on
 * each action of user.
 */
public class GameRefereeServiceImpl implements GameRefereeService {

	@Override
	public void updateGameOnAction(Game game, int powerToReduce) {
		Player player = game.getPlayer();
		Barrier barrier = game.getCurrentBarrier();

		if (powerToReduce > player.getPower()) {
			powerToReduce = player.getPower();
		}

		barrier.setCapacity(barrier.getCapacity() - powerToReduce);
		player.setPower(player.getPower() - powerToReduce);

		if (player.getPower() == 0 && barrier.getCapacity() <= 0 && isLastBarrier(game)) {
			System.out.println("Glad you completed the loot but, you consumed your all power!");
			game.setGameOver(true);
			return;
		}
		game.setGameOver(isPlayerDead(player));

		if (barrier.getCapacity() <= 0) {
			System.out.println(
					"Bingo! you broke the barrier " + barrier.getBarrierNumber() + " & looted $" + barrier.getBonus());
			player.setTotalLoot(player.getTotalLoot() + barrier.getBonus());

			if (isLastBarrier(game)) {
				game.setGameOver(true);
				return;
			} else {
				loadNextBarrier(game);
			}
		}
		System.out.println("barrier capacity ::"
				+ (game.getCurrentBarrier().getCapacity() < 0 ? 0 : game.getCurrentBarrier().getCapacity()));
		System.out.println("your power::" + player.getPower());
	}

	private void loadNextBarrier(Game game) {
		System.out.println("loading your next barrier...");
		game.setCurrentBarrier(game.getBarrierMap().get(game.getCurrentBarrier().getBarrierNumber() + 1));
	}

	private boolean isLastBarrier(Game game) {
		return game.getCurrentBarrier().getBarrierNumber() == game.getBarrierMap().size();
	}

	private boolean isPlayerDead(Player player) {
		if (player.getPower() <= 0) {
			System.out.println("Game Over!You are dead.");
			return true;
		}
		return false;
	}
}
