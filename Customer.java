package com.tka.oct_15;

public class Customer {

	private int customerId;
	private String customerName;
	private String mobileNumber;
	private String address;

	public Customer() {

	}

	public Customer(int customerId, String customerName, String mobileNumber, String address) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNumber="
				+ mobileNumber + ", address=" + address + "]";
	}

}
