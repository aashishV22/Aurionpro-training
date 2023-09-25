package com.auriopro.model;

import java.time.LocalDate;

public class Car extends Vehicle implements IMovable{

	
	
	public Car(String model, LocalDate dOm) {
		super(model, dOm);

	}

	@Override
	public void showTopSpeed() 
	{
		System.out.println("Top speed of car is 40");
	}

	@Override
	public void move() {
		System.out.println("Car is moving");
		
	}
}
