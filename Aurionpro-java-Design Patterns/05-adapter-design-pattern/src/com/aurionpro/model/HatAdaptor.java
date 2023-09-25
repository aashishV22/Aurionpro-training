package com.aurionpro.model;

public class HatAdaptor implements IItems{
	private Hat hat;
	
	
	public HatAdaptor(Hat hat) {
		super();
		this.hat = hat;
	}

	@Override
	public String toString() {
		return "HatAdaptor [hat=" + hat + "]";
	}

	@Override
	public String getItemName() {
		
		return hat.getLongName();
	}

	@Override
	public double getItemPrice() {
		return hat.getBasicPrice()+hat.getBasicPrice()*(hat.getTax()/100);
	}

}
