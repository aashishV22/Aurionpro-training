package com.aurionpro.model;

public class CarPrice extends FourWheeler{
	int price;
	public CarPrice(String companyName, int mileage, int price) {
		super(companyName, mileage);
		this.price = price;
	}
	@Override
	public String toString() {
		return "CarPrice [price=" + price + ", mileage=" + mileage + ", companyName=" + companyName + "]";
	}


}