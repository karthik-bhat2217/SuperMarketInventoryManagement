package com.mindtree.SuperMarketInventoryManagemant.entity;

public class SuperMarket {
	private int id;
	private String name;
	private float rating;
	private int itemAvailableCount;
	public SuperMarket() {
		// TODO Auto-generated constructor stub
	}
	public SuperMarket(int id, String name, float rating, int itemAvailableCount) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.itemAvailableCount = itemAvailableCount;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}
	/**
	 * @return the itemAvailableCount
	 */
	public int getItemAvailableCount() {
		return itemAvailableCount;
	}
	/**
	 * @param itemAvailableCount the itemAvailableCount to set
	 */
	public void setItemAvailableCount(int itemAvailableCount) {
		this.itemAvailableCount = itemAvailableCount;
	}
	
	

}
