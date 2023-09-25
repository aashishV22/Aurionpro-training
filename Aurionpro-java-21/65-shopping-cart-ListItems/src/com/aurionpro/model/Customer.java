package com.aurionpro.model;

import java.util.List;

public class Customer 
{
	public int customerID;
	public String customerName;
	public List<Order> orders;
	public static double totalOrderCost;
	public Customer(int customerID, String customerName, List<Order> orders) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.orders = orders;
		this.totalOrderCost=calculateTotalOrderCost();
	}
	
	private  double calculateTotalOrderCost() {
		for(Order x:orders) {
			totalOrderCost+=x.totalCost;
		}
	
		return totalOrderCost;
	}

	public double getTotalOrderCost() {
		return totalOrderCost;
	}

	public static void setTotalOrderCost(double totalOrderCost) {
		totalOrderCost = totalOrderCost;
	}

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", orders=" + orders + "]\n********Total Order Cost is**********\nRs-"+totalOrderCost;
	}
	
	
	
}
