package com.aurionpro.model;

public class OilChange extends CarServiceDecorator{
	private ICarService obj;

	public OilChange(ICarService obj) {
		super(obj);
	} 
	@Override
	public double getCost() {
		return 500+ super.getCost();
	}	

}
