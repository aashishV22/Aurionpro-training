package com.aurionpro.test;

import com.aurionpro.model.Border;
import com.aurionpro.model.Circle;
import com.aurionpro.model.Color;


public class CircleTest {
	public static void main(String[] args) {
		Circle circle1=new Circle();
		circle1.setRadius(14);
		circle1.setColour(Color.BLUE);
		circle1.setBorder(Border.Dotted);
		System.out.println("Area of circle is "+ circle1.getArea());
		System.out.println("Colour is "+circle1.getColour());
		System.out.println("Border is "+circle1.getBorder());
		
		/*
		Rectangle rectangle2=new Rectangle();
		rectangle2.height=13;
		rectangle2.width=4;
		System.out.println("Area of rectangle2 is "+rectangle2.calculateArea());
		*/
	}

}
