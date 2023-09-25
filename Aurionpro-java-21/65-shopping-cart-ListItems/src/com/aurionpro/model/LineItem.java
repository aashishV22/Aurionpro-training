package com.aurionpro.model;

public class LineItem 
{
	private int productId;
	private int productQuantity;
	public Product product;
	private double lineItemPrice;
	public LineItem(int productId, int productQuantity, Product product) {
		super();
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.product = product;
		this.lineItemPrice=calculateLineItemCost();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getLineItemPrice() {
		return lineItemPrice;
	}
	public void setLineItemPrice(double lineItemPrice) {
		this.lineItemPrice = lineItemPrice;
	}
	public double calculateLineItemCost() {
		this.setLineItemPrice(productQuantity*product.calculateDiscountedPrice());
		return this.getLineItemPrice();
	
	}
	@Override
	public String toString() {
		return "LineItem [productId=" + productId + ", productQuantity=" + productQuantity + ", product=" + product
				+ "->>>> lineItemPrice=" + lineItemPrice + "]\n";
	}

	
}

