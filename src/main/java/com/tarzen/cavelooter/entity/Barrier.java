package com.tarzen.cavelooter.entity;

/**
 * @author Poorva Adarshe
 * 
 * Entity class holding Barrier information.
 *
 */
public class Barrier {

	private int barrierNumber;
	private int capacity;
	private int bonus;

	/**
	 * 
	 */
	public Barrier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param barrierNumber
	 * @param capacity
	 * @param bonus
	 */
	public Barrier(int barrierNumber, int capacity, int bonus) {
		super();
		this.barrierNumber = barrierNumber;
		this.capacity = capacity;
		this.bonus = bonus;
	}

	/**
	 * @return the barrierNumber
	 */
	public int getBarrierNumber() {
		return barrierNumber;
	}

	/**
	 * @param barrierNumber the barrierNumber to set
	 */
	public void setBarrierNumber(int barrierNumber) {
		this.barrierNumber = barrierNumber;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + barrierNumber;
		result = prime * result + bonus;
		result = prime * result + capacity;
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
		Barrier other = (Barrier) obj;
		if (barrierNumber != other.barrierNumber)
			return false;
		if (bonus != other.bonus)
			return false;
		if (capacity != other.capacity)
			return false;
		return true;
	}
}