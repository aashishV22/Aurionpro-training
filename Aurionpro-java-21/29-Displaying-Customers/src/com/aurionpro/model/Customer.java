package com.aurionpro.model;

public class Customer {
	private int customerID;
	private String name;
	private String email;
	private int password;

	public Customer(int customerID, String name, String email, int password) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() 
	{	return "Customer [customerID=" + customerID + ", name=" + name + ", email=" + email + ", password=" + password + "]";	}
}
