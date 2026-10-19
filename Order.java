package com.tka.oct_15;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderId;
	private Customer customer;
	private List<FoodItem> orderedItems;
	private double totalAmount;
	private String status;

	public Order() {

	}

	public Order(int orderId, Customer customer, List<FoodItem> orderedItems, double totalAmount, String status) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderedItems = new ArrayList<FoodItem>();
		this.totalAmount = 0;
		this.status = "Placed";

		for (FoodItem items : orderedItems) {
			totalAmount += items.getPrice();
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<FoodItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<FoodItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void updateStatus(String status) {
		this.status = status;
	}

	
}
