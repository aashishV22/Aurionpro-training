package com.aurionpro.test;

import com.aurionpro.model.*;

public class CarFactoryTest {
	public static void main(String[] args) {
		CarFactory factory=new CarFactory();
		ICars maruti=factory.makeCars(ECarType.Maruti);
		maruti.start();
	}
}
