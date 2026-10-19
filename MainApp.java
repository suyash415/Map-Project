package com.tka.oct_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("@@ Welcome to Zomato App @@");

		Scanner sc = new Scanner(System.in);

		List<FoodItem> foodList = new ArrayList<>();

		foodList.add(new FoodItem(101, "Veg Pizza", "Pizza", 250));
		foodList.add(new FoodItem(102, "Chicken Burger", "Burger", 180));
		foodList.add(new FoodItem(103, "Veg Biryani", "Biryani", 150));
		foodList.add(new FoodItem(104, "Chicken Biryani", "Biryani", 280));
		foodList.add(new FoodItem(105, "Masala Dosa", "South Indian", 100));
		foodList.add(new FoodItem(106, "Paneer Tikka", "Starter", 220));
		foodList.add(new FoodItem(107, "French Fries", "Snacks", 120));
		foodList.add(new FoodItem(108, "Cold Coffee", "Beverage", 120));

		Customer c1 = new Customer(11, "Swapnil", "909876544", "Pune");

		// Create HashMap for food items

		Map<Integer, FoodItem> foodMenu = new HashMap<>();

		for (FoodItem f : foodList) {
			foodMenu.put(f.getId(), f);
		}

		// Display food menu

		System.out.println("\n===== FOOD MENU =====");

		for (FoodItem f : foodList) {
			System.out.println(f.getId() + " : " + f.getName() + " : Rs." + f.getPrice());
		}

		// Select multiple food items

		int[] foodIds = new int[10];
		int index = 0;
		char next;

		do {
			System.out.print("\nEnter food item ID: ");
			int selectedFoodItemId = sc.nextInt();

			if (foodMenu.containsKey(selectedFoodItemId)) {

				if (index < foodIds.length) {
					foodIds[index++] = selectedFoodItemId;
					System.out.println("Food item added.");
				} else {
					System.out.println("Maximum 10 items allowed.");
				}

			} else {
				System.out.println("Invalid food item ID.");
			}

			System.out.print("Do you want to add more? (y/n): ");
			next = sc.next().charAt(0);

		} while (next == 'y' || next == 'Y');

		// Store selected food items in ArrayList

		List<FoodItem> c1FoodItemList = new ArrayList<>();

		for (int i = 0; i < index; i++) {
			int foodId = foodIds[i];
			c1FoodItemList.add(foodMenu.get(foodId));
		}

		// Calculate total amount

		double totalAmt = 0;

		for (FoodItem foodItem : c1FoodItemList) {
			totalAmt += foodItem.getPrice();
		}

		// Create order

		Order o1 = new Order();

		o1.setOrderId((int) (Math.random() * 1000) + 1);
		o1.setCustomer(c1);
		o1.setOrderedItems(c1FoodItemList);
		o1.setStatus("Ready");
		o1.setTotalAmount(totalAmt);

		// Display bill

		System.out.println("\n===== ZOMATO ORDER BILL =====");
		System.out.println("Order ID: " + o1.getOrderId());
		System.out.println("Customer: " + c1.getCustomerName());
		System.out.println("Address: " + c1.getAddress());

		System.out.println("\nSelected Food Items:");

		for (FoodItem foodItem : c1FoodItemList) {
			System.out.println(foodItem.getName() + " - Rs." + foodItem.getPrice());
		}

		System.out.println("-------------------------");
		System.out.println("Total Amount: Rs." + totalAmt);
		System.out.println("Order Status: " + o1.getStatus());

		sc.close();
	}
}
