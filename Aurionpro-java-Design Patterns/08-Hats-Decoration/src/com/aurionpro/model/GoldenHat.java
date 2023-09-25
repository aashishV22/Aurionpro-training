package com.aurionpro.model;

public class GoldenHat extends HatDecorator{

	public GoldenHat(IHat obj) {
		super(obj);
	}

	@Override
	public String getName() {
		return super.getName()+" Golden Hat";
	}
	
	@Override
	public double getPrice() {
		return super.getPrice()+400;
	}
}
