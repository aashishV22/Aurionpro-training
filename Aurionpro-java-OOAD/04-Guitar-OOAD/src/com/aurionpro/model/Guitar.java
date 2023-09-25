package com.aurionpro.model;

public class Guitar 
{
	private String	   serialNumber;
	private double 	   price;
	private GuitarSpec specs;
	
	public Guitar(String serialNumber, double price,GuitarSpec specs ) {
		super();
		this.serialNumber = serialNumber;
		this.price = price;
		this.specs=specs;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public GuitarSpec getSpecs() {
		return specs;
	}
	public void setSpecs(GuitarSpec specs) {
		this.specs = specs;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Guitar [serialNumber=" + serialNumber + ", price=" + price + ", specs=" + specs + "] \n";
	}
	
}
