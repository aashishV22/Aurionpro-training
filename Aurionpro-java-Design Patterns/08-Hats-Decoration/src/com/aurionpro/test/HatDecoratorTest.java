package com.aurionpro.test;

import com.aurionpro.model.*;

public class HatDecoratorTest 
{
	public static void main(String[] args) {
		IHat hat=new StandardHat();
		HatDecorator ribbonHat=new RibbonedHat(hat);
		HatDecorator goldenHat=new GoldenHat(ribbonHat);
		System.out.println(goldenHat.getName());
		System.out.println(goldenHat.getPrice());
	}
}
