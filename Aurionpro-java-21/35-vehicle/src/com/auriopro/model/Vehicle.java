package com.auriopro.model;

import java.time.LocalDate;

public abstract class Vehicle {
	private String model;
	private LocalDate dOm;
	
	public abstract void showTopSpeed();

	public Vehicle(String model, LocalDate dOm) {
		super();
		this.model = model;
		this.dOm = dOm;
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", dOm=" + dOm + "]";
	}
	


}
