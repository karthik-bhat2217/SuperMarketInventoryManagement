package com.mindtree.SuperMarketInventoryManagemant.entity;

public class ItemSold  implements Comparable<ItemSold>{
	private int id;
	private String name;
	private float price;
	private int itemSoldCount;
	public ItemSold() {
		// TODO Auto-generated constructor stub
	}
	public ItemSold(int id, String name, float price, int itemSoldCount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.itemSoldCount = itemSoldCount;
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
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the itemSoldCount
	 */
	public int getItemSoldCount() {
		return itemSoldCount;
	}
	/**
	 * @param itemSoldCount the itemSoldCount to set
	 */
	public void setItemSoldCount(int itemSoldCount) {
		this.itemSoldCount = itemSoldCount;
	}
	public int compareTo(ItemSold o) {
		// TODO Auto-generated method stub
		return (int)(o.getPrice()-this.getPrice());
	}
	

}
