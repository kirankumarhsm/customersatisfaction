package com.techolution.assigment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.core.io.ClassPathResource;

/**
 * Consumer consumes the data to process the dishes
 * 
 * @author kirankumar
 *
 */
public class Customer {

	private FoodMenu foodMenu = null;
	private String customerName = null;
	private int timeToEatDish;
	private int timeToEatAllDishes = 0;
	private Boolean timeCheck = Boolean.FALSE;
	private int itemCount = 0;

	public Customer(String customerName, int totalTimeToEat, FoodMenu foodMenu) {
		this.customerName = customerName;
		this.timeToEatDish = totalTimeToEat * 60;
		this.foodMenu = foodMenu;

		try {
			readAndComputeData();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This Method will tokanize and populate the data by reading the input, print the result
	 * @throws IOException 
	 */
	public void readAndComputeData() throws IOException {
		File file = new ClassPathResource("data.txt").getFile();
		Path path = Paths.get(file.toURI());
		try (Stream<String> lines = Files.lines(path)) {
			lines.forEach(line -> {
				if (!timeCheck) {
					itemCount = itemCount + 1;
					int timeTakenPerDish = 0;
					StringTokenizer tokens = new StringTokenizer(line, " ");
					List<MenuItem> itemList =  foodMenu.getFoodItems();
					Arrays.sort(itemList.toArray(), 
							(o1, o2) -> 
					((MenuItem) o2).getSatisfactoryLimit() - ((MenuItem) o1).getSatisfactoryLimit());
					
                    MenuItem item = itemList.get(itemCount);
					
					item.setSatisfactoryLimit(Integer.parseInt(tokens.nextToken()));
					if (tokens.hasMoreElements()) {
						timeTakenPerDish = Integer.parseInt(tokens.nextToken());
						item.setTimeTaken(timeTakenPerDish);
					}
					timeToEatAllDishes = timeToEatAllDishes + timeTakenPerDish;
					if (timeToEatAllDishes > timeToEatDish) {
						timeCheck = Boolean.TRUE;
						return;
					}
					System.out.println(customerName + " customer took the items in " + item.getItemName()
							+ " for about " + item.getTimeTaken() + " secs "
							+ "and satisfactory level is " + item.getSatisfactoryLimit());
				}
			});
			
		} catch (IOException ex) {
              ex.printStackTrace();
		}

	}

}
