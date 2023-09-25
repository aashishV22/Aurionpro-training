package com.aurionpro.model;

public class Feet {
	private int feet;
	private int inches;
	
	
	
	
	public Feet(int feet, int inches) {
		super();
		this.feet = feet;
		this.inches = inches;
	}




	public int getFeet() {
		return feet;
	}




	public void setFeet(int feet) {
		this.feet = feet;
	}




	public int getInches() {
		return inches;
	}




	public void setInches(int inches) {
		this.inches = inches;
	}




	@Override
	public String toString() {
		return "Addition and conversion [feet=" + feet + ", inches=" + inches + "]";
	}

	
	
}
