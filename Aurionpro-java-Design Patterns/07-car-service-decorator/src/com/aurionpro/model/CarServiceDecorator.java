package com.aurionpro.model;

public abstract class CarServiceDecorator implements ICarService{

	private ICarService carObj;
	
	public CarServiceDecorator(ICarService obj) {
		this.carObj=obj;
	}

	@Override
	public double getCost() {
		return carObj.getCost();
	}

}
