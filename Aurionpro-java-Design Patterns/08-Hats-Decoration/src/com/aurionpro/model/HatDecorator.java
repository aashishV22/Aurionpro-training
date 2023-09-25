package com.aurionpro.model;

public abstract class HatDecorator implements IHat
{
	private IHat hatObj;
	
	public HatDecorator(IHat obj) {
		this.hatObj=obj;
	}
	
	@Override
	public String getName() {
		return hatObj.getName();
	}
	
	@Override
	public double getPrice() {
		return hatObj.getPrice();
	}

}
