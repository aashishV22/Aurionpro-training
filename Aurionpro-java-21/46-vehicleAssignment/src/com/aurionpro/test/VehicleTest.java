package com.aurionpro.test;

import com.aurionpro.model.CarPrice;

public class VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarPrice[] vehicles = {
				new CarPrice("Suzuki", 30, 600000),
				new CarPrice("Honda", 30, 600000),
				new CarPrice("MG", 25, 700000),
		};
		for(CarPrice x:vehicles) {
			System.out.println(x);
		}
	}

}