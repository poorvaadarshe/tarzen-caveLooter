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
 * 
 * Single point of modification to add/remove difficulty levels such as -
 * increase in life of player on each barrier crossed.
 */
public class GameRefereeServiceImpl implements GameRefereeService {

	@Override
	public void updateGameOnAction(Game game, int powerToReduce) {
		Player player = game.getPlayer();
		Barrier barrier = game.getCurrentBarrier();

		updateUserPowerAndBarrierCapacity(powerToReduce, player, barrier);

		// Scenario : on current action performed, player's power becomes zero, breaking
		// the last barrier.
		if (player.getPower() == 0 && barrier.getCapacity() <= 0 && isLastBarrier(game)) {
			System.out.println("Glad you completed the loot but, you consumed your all power!");
			game.setGameOver(true);
			return;
		}
		// set game over if player is dead.
		game.setGameOver(isPlayerDead(player));

		// player is alive and current barrier is broken, load next barrier for player
		// if he is not on last barrier.
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
		// read status of game on current action.
		readCurrentGameStatus(game, player);
	}

	/**
	 * Reads current game status.
	 * 
	 * @param game
	 * @param player
	 */
	private void readCurrentGameStatus(Game game, Player player) {
		System.out.println("barrier capacity ::"
				+ (game.getCurrentBarrier().getCapacity() < 0 ? 0 : game.getCurrentBarrier().getCapacity()));
		System.out.println("your power::" + player.getPower());
	}

	/**
	 * Reduce power and capacity of player & barrier respectively by action's
	 * allocated power.
	 * 
	 * @param powerToReduce
	 * @param player
	 * @param barrier
	 */
	private void updateUserPowerAndBarrierCapacity(int powerToReduce, Player player, Barrier barrier) {

		// If player's power is less than action's allocated power then, assigning
		// lesser value among it to be reduced.
		if (powerToReduce > player.getPower()) {
			powerToReduce = player.getPower();
		}

		// reduce barrier capacity and player's power by powerToReduce
		barrier.setCapacity(barrier.getCapacity() - powerToReduce);
		player.setPower(player.getPower() - powerToReduce);
	}

	/**
	 * Loads next barrier for player's further game.
	 * 
	 * @param game
	 */
	private void loadNextBarrier(Game game) {
		System.out.println("loading your next barrier...");
		game.setCurrentBarrier(game.getBarrierMap().get(game.getCurrentBarrier().getBarrierNumber() + 1));
	}

	/**
	 * checks if current barrier is the last barrier.
	 * 
	 * @param game
	 * @return
	 */
	private boolean isLastBarrier(Game game) {
		return game.getCurrentBarrier().getBarrierNumber() == game.getBarrierMap().size();
	}

	/**
	 * checks is player dead.
	 * 
	 * @param player
	 * @return
	 */
	private boolean isPlayerDead(Player player) {
		if (player.getPower() <= 0) {
			System.out.println("Game Over!You are dead.");
			return true;
		}
		return false;
	}
}
