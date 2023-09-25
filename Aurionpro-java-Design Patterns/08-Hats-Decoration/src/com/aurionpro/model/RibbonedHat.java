package com.aurionpro.model;

public class RibbonedHat extends HatDecorator
{
	public RibbonedHat(IHat obj) {
		super(obj);
	}

	@Override
	public String getName() {
		return super.getName()+" Ribboned Hat";
	}
	
	@Override
	public double getPrice() {
		return super.getPrice()+300;
	}
	
}
