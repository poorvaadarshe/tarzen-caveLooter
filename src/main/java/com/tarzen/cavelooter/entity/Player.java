/**
 * 
 */
package com.tarzen.cavelooter.entity;

/**
 *
 */
public class Player {

	private String playerId;
	private String playerName;
	private String country;
	private int power;
	private int totalLoot = 0;

	/**
	 * 
	 */
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param playerId
	 * @param playerName
	 * @param age
	 * @param power
	 */
	public Player(String playerId, String playerName, String country, int power) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.country = country;
		this.power = power;
	}

	public Player(Player player) {
		this.playerId = player.getPlayerId();
		this.playerName = player.getPlayerName();
		this.country = player.getCountry();
		this.power = player.getPower();
	}

	/**
	 * @return the playerId
	 */
	public String getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the age
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param age the age to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * @return the totalLoot
	 */
	public int getTotalLoot() {
		return totalLoot;
	}

	/**
	 * @param totalLoot the totalLoot to set
	 */
	public void setTotalLoot(int totalLoot) {
		this.totalLoot = totalLoot;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Player Id : " + playerId + " Player Name : " + playerName + " Country : " + country + " Power : "
				+ power;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + power;
		result = prime * result + totalLoot;
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (power != other.power)
			return false;
		if (totalLoot != other.totalLoot)
			return false;
		return true;
	}

}