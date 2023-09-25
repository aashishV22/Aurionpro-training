package com.aurionpro.model;

public class CarFactory 
{
	public ICars makeCars(ECarType car ) {
		if(car==ECarType.Maruti) {
			return new Maruti();
		}
		if(car==ECarType.Tata) {
			return new Tata();
		}
		if(car==ECarType.Mahindra) {
			return new Maruti();
		}
		return null;
	}
}
