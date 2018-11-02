package com.tarzen.cavelooter.entity;

import java.util.Map;

public class Game {
	
	private Player player;
	private Barrier currentBarrier;
	private boolean isGameOver = false;
	Map<Integer,Barrier> barrierMap;
	
	/**
	 * @return the barrierMap
	 */
	public Map<Integer, Barrier> getBarrierMap() {
		return barrierMap;
	}
	/**
	 * @param barrierMap the barrierMap to set
	 */
	public void setBarrierMap(Map<Integer, Barrier> barrierMap) {
		this.barrierMap = barrierMap;
	}
	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	/**
	 * @return the barrier
	 */
	public Barrier getCurrentBarrier() {
		return currentBarrier;
	}
	/**
	 * @param barrier the barrier to set
	 */
	public void setCurrentBarrier(Barrier barrier) {
		this.currentBarrier = barrier;
	}
	/**
	 * @return the isGameOver
	 */
	public boolean isGameOver() {
		return isGameOver;
	}
	
	/**
	 * @param isGameOver the isGameOver to set
	 */
	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return player.getPlayerName()+"("+player.getCountry()+") is on barrier "+currentBarrier.getBarrierNumber()+" and looted $"+player.getTotalLoot()+" Remaining power : "+player.getPower();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrierMap == null) ? 0 : barrierMap.hashCode());
		result = prime * result + ((currentBarrier == null) ? 0 : currentBarrier.hashCode());
		result = prime * result + (isGameOver ? 1231 : 1237);
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (barrierMap == null) {
			if (other.barrierMap != null)
				return false;
		} else if (!barrierMap.equals(other.barrierMap))
			return false;
		if (currentBarrier == null) {
			if (other.currentBarrier != null)
				return false;
		} else if (!currentBarrier.equals(other.currentBarrier))
			return false;
		if (isGameOver != other.isGameOver)
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}
	
}
