package com.aurionpro.test;

import com.aurionpro.model.Biscuit;
import com.aurionpro.model.Hat;
import com.aurionpro.model.HatAdaptor;
import com.aurionpro.model.ShoppingCart;

public class AdaptorTest {

	public static void main(String[] args) {
		ShoppingCart cart= new ShoppingCart();
		Biscuit tiger=new Biscuit("Tiger", 20);
		Hat hat=new Hat("hat","redHat", 40, 10);
		HatAdaptor newHat=new HatAdaptor(hat);
		
		cart.addItemtoCart(tiger);
		cart.addItemtoCart(newHat);
		
		cart.getCartItems().stream()
			.forEach(System.out::println);
		System.out.println("Total cart price "+cart.getCartPrice());
	}

}
