package com.aurionpro.model;

import java.time.LocalDate;
import java.util.*;

public class Order 
{
	public int orderID;
	public LocalDate orderDate=LocalDate.now();
	public List<LineItem> items;
	public double totalCost=0;
	public Order(int orderID, LocalDate orderDate, List<LineItem> items) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.items = items;
		this.totalCost=calculatedOrderPrice();
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public List<LineItem> getItems() {
		return items;
	}
	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	
	public  double getTotalCost() {
		return totalCost;
	}
	public  void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double calculatedOrderPrice() {
		for(LineItem x:items) {
			this.setTotalCost(totalCost+x.calculateLineItemCost());
		}
		return this.getTotalCost();
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderDate=" + orderDate + ",\nitems=\n" + items + "==>>>> totalCart cost="
				+ totalCost + "]\n";
	}
			
}
