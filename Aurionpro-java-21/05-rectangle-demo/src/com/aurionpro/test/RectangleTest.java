package com.aurionpro.test;

import com.aurionpro.model.Rectangle;

public class RectangleTest {
	public static void main(String[] args) {
		Rectangle rectangle=new Rectangle();
		rectangle.height=14;
		rectangle.width=9;
		//System.out.println(rectangle.calculateArea());
		
		
		Rectangle rectangle2=new Rectangle();
		rectangle2.height=13;
		rectangle2.width=4;
		System.out.println("Area of rectangle2 is "+rectangle2.calculateArea());
		
	}

}
