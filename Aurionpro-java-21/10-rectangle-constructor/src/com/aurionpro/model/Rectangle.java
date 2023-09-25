package com.aurionpro.model;

public class Rectangle {
	private double height;
	private double width;
	private Color colour;

	public Rectangle(double height, double width, Color color) {
		this.height = height;
		this.width = width;
		this.colour = color;

	}

	public Rectangle() {
		this.height = 0.0;
		this.width = 0.0;
		this.colour = Color.Yellow;

	}

	public void setHeight(double height) {
		this.height = correctedValue(height);
	}

	public void setWidth(double width) {
		this.width = correctedValue(width);
	}

	public void setColour(Color colour) {
		this.colour = colour;
//		if(colour.equalsIgnoreCase("red") || colour.equalsIgnoreCase("blue") || colour.equalsIgnoreCase("green"))
		// {
//			this.colour=colour;
//		}
///		else {
//			this.colour="Red";
//		}

	}

	/*
	 * public void setHeight(double height) { if (height < 1) { this.height=1; }
	 * else if(height>100) { this.height=100; } else { this.height=height; } }
	 *
	 * public void setWidth(double width) { if (width < 1) { this.width = 1; } else
	 * if(width>100) { this.width=100; } else { this.width=width; } }
	 */
	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public Color getColour() {
		return colour;
	}

	private double correctedValue(double value) {
		if (value < 1) {
			value = 1;
		} else if (value > 100) {
			value = 100;
		} else {
			value = value;
		}
		return value;
	}

	public double calculateArea() {
		double area = height * width;
		return area;
	}

}
