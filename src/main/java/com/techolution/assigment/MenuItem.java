package com.techolution.assigment;

/**
 * Item is a POJO.
 * 
 * @author KiranKumar
 *
 */
public class MenuItem {

	private int itemId;

	private String itemName;

	private int satisfactoryLimit;

	private int timeTaken;

	public MenuItem(int itemId, String itemName) {
		this.itemName = itemName;
		this.itemId = itemId;
	}

	public int getSatisfactoryLimit() {
		return satisfactoryLimit;
	}

	public void setSatisfactoryLimit(int satisfactoryLimit) {
		this.satisfactoryLimit = satisfactoryLimit;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemId() {
		return itemId;
	}

}
