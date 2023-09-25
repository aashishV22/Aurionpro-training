package com.aurionpro.test;

import com.aurionpro.model.*;

public class CarFactoryTest {
	public static void main(String[] args) {
		ICarFactory marutiFactory=MarutiFactory.getFactory();
		ICars maruti = marutiFactory.makeCars();
		maruti.start();
		marutiFactory.printGreetings();
		ICarFactory marutiFactory1=MarutiFactory.getFactory();
		ICars maruti1 = marutiFactory.makeCars();
		marutiFactory1.printGreetings();
		maruti1.start();
		
	}
}
