package com.aurionpro.test;

import com.aurionpro.model.*;

public class LaptopTest {
	public static void main(String[] args) {
		LaptopBuilder builder=new LaptopBuilder();
		builder.addBrand("hp");
		builder.addBrand("dell");
		
		IGadgets newLaptop=builder.build();
		System.out.println(newLaptop.getBrand());
		
	}
}
