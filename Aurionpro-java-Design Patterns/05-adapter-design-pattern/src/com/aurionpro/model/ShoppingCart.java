package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShoppingCart {

	private List<IItems> cartItems;
	
	public ShoppingCart() {
		this.cartItems=new ArrayList<IItems>();
	}

	public void addItemtoCart(IItems item) {
		this.cartItems.add(item);
	}

	public List<IItems> getCartItems(){
		return cartItems;
	}

	public double getCartPrice() {
		Double price = cartItems.stream()
				.map(cartItem->cartItem.getItemPrice())
				.reduce(0.0,(a,b)->a+b);
		return price;
	}
}
