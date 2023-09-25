package com.aurionpro.model;

public class PremiumHat implements IHat{
	private String name="Premium";
	@Override
	public String getName() {
		return name ;
	}

	@Override
	public double getPrice() {
		return 400;
	}

}
