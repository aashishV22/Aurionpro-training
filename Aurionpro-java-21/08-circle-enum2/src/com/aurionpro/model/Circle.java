package com.aurionpro.model;

public class Circle 
{
	private double radius;
	private Color colour;
	private Border border;
	private double area;
	public void setRadius(double radius) 
	{
		this.radius=(radius);
	}
	public void setBorder(Border border) {
		this.border=border;
	}
	public void setColour(Color colour) 
	{
		this.colour=colour;
//		if(colour.equalsIgnoreCase("red") || colour.equalsIgnoreCase("blue") || colour.equalsIgnoreCase("green"))
	//	{
//			this.colour=colour;
//		}
///		else {
//			this.colour="Red";
//		}
		

	}
/*	public void setHeight(double height) {
		if (height < 1) {
			this.height=1;
		}
		else if(height>100) {
			this.height=100;
		}
		else {
			this.height=height;
		}
	}	

	public void setWidth(double width) {
		if (width < 1) {
			this.width = 1;
		}
		else if(width>100) {
			this.width=100;
		}
		else {
			this.width=width;
		}
	}
*/
		public double getRadius() 
	{
		return radius;
	}

	public Border getBorder() 
	{
		return border;
	}

	public Color getColour() 
	{
		return colour;
	}
	public double getArea() {
		return calculatedArea();
	}
	
	public double calculatedArea() 
	{
		// area =Math.p1*
		area=3.14*radius*radius;
		return area;
	}	
	
	/*
	 * public double calculateArea() { double area = height * width;
	 * //System.out.println("Area of " + area); return area; }
	 */
}
