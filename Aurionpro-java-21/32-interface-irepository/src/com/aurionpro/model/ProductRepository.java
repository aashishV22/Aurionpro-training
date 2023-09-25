package com.aurionpro.model;

public class ProductRepository implements IRepository{

	@Override
	public void create() {
		System.out.println("Product is created");
	}

	@Override
	public void read() {
		System.out.println("Product is readed");
	}
	

}
