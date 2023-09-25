package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Product 
{
	public int 	  productId;
	public String productName;
	public double productPrice;
	public double discountedPercent;
	public double discountedPrice;
	public Product(int productId, String productName, double productPrice, double discountedPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.discountedPercent = discountedPrice;
		this.discountedPrice=discountedPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getDiscountedPrice() {
		return discountedPercent;
	}
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPercent = discountedPrice;
	}
	
	public double getDiscountedPercent() {
		return discountedPercent;
	}
	public void setDiscountedPercent(double discountedPercent) {
		this.discountedPercent = discountedPercent;
	}
	public double calculateDiscountedPrice() {
		return this.discountedPrice=this.productPrice-((productPrice*discountedPercent)/100);
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", discountedPercent=" + discountedPercent + ", discountedPrice=" + discountedPrice + "]";
	}
	
}
