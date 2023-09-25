package com.aurionpro.test;

import com.aurionpro.model.CarInspection;
import com.aurionpro.model.CarServiceDecorator;
import com.aurionpro.model.ICarService;
import com.aurionpro.model.OilChange;
import com.aurionpro.model.WheelAlign;

public class CarSeviceTest 
{
	public static void main(String[] args) {
		ICarService car = new CarInspection();
		CarServiceDecorator carOil=new OilChange(car);
		CarServiceDecorator carWheel= new WheelAlign(carOil);
		System.out.println(carWheel.getCost());
	}
}
