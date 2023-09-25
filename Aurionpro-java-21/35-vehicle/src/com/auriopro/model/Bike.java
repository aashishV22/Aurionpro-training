package com.auriopro.model;

import java.time.LocalDate;

public class Bike extends Vehicle implements IMovable{
	public Bike(String model, LocalDate dOm) {
		super(model, dOm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showTopSpeed() 
	{
		System.out.println("Top speed of bike is 180");
	}

	@Override
	public void move() {
		System.out.println("bike is moving at high speed...");
		
	}
}