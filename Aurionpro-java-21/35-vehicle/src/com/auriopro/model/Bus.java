package com.auriopro.model;

import java.time.LocalDate;

public class Bus extends Vehicle implements IMovable{

	public Bus(String model, LocalDate dOm) {
		super(model, dOm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		System.out.println("Bus is moving");
	}

	@Override
	public void showTopSpeed() {
		System.out.println("Top speed of bus is 60km/hr");
		
	}

}
