package com.techolution.assigment;

import java.util.Scanner;

/**
 * Assignment to compute the maximum satisfaction 
 * the customer can from eating at the restaurant.
 * 
 */

public class Restaurant {

	private static FoodMenu foodMenu;

	private static Scanner scanner;

	/**
	 * Read the Input for the Customer Name and Time
	 * 
	 * @param args
	 */

	 public Restaurant() {

		String customerName;
		int timeToEat;

		scanner = new Scanner(System.in);
		customerName = scanner.next();
		timeToEat = scanner.nextInt();

		System.out.println("Customer name -" + customerName);
		System.out.println("Time to Eat in mins - " + timeToEat);

		foodMenu = FoodMenu.getInstance();
		new Customer(customerName, timeToEat, foodMenu);

	}

}
