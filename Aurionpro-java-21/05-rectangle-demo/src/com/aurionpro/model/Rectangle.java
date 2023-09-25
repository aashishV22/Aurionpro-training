package com.aurionpro.model;

public class Rectangle {
	public double height;
	public double width;
	public double calculateArea() {
		double area=height*width;
		System.out.println("Area of "+area);
		return area;
	}
	
}
