package com.aurionpro.model;

public class StandardHat implements IHat
{
	private String name="Standard";
		
	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return 200;
	}

}
