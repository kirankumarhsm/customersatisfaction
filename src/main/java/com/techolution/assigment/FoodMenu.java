package com.techolution.assigment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Food Menu with list of items to serve to customer in the restaurant
 * 
 * @author kirankumar
 *
 */
public class FoodMenu {

	private List<MenuItem> menuItemsList = new ArrayList<>(101);
	private static FoodMenu foodMenu;

	private FoodMenu() {
	 menuItemsList = IntStream.rangeClosed(0, 100)
			    .mapToObj(i -> new MenuItem(i, "Item -" + i))
			      .collect(Collectors.toList());
		
	}

	public static FoodMenu getInstance() {
		if (foodMenu == null)
			foodMenu = new FoodMenu();
		return foodMenu;

	}

	public void setFoodItems(List<MenuItem> menuItemsList) {
		this.menuItemsList = menuItemsList;
	}

	public List<MenuItem> getFoodItems() {
		return this.menuItemsList;
	}

}
