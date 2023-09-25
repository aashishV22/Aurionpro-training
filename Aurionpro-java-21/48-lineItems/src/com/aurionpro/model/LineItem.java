package com.aurionpro.model;

import java.util.List;

public class LineItem 
{
	private int itemId;
	private String itemName;
	private int quantity;
	private double unitPrice;
	private double totalCost;
	private static double totalCartCost;
	public LineItem(int itemId, String itemName, int quantity, double unitPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalCost=this.getUnitPrice()*this.getQuantity();
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public static double totalCaetCost(List<LineItem> LineItems) {
		for(int i=0;i<((List<LineItem>)LineItems).size();i++) {
			totalCartCost+=LineItems.get(i).getTotalCost();
		}
		return totalCartCost; 
	}
	
	@Override
	public String toString() {
		return "LineItem [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", totalCost=" + totalCost + "]";
	}
	
	
	
}
