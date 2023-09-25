package com.aurionpro.test;

import com.aurionpro.model.Color;
import com.aurionpro.model.Rectangle;
import java.util.Scanner;

public class RectangleTest {
	public static void main(String[] args) {
	
		Rectangle rectangle1=new Rectangle();
		setRectangleDetails(rectangle1);
		getArea(rectangle1);
		System.out.println("************");
		Rectangle rectangle2=new Rectangle();
		setRectangleDetails(rectangle2);
		getArea(rectangle2);
		}
	
	private static void getArea(Rectangle rectangle) 
	{
		System.out.println("Area is "+rectangle.getHeight()*rectangle.getWidth());
		System.out.println("Colour is "+rectangle.getColour());
	}
		
	private static void setRectangleDetails(Rectangle rectangle) 
	{
		Scanner input = new Scanner(System.in);		
		System.out.print("Enter height: ");
		int height=input.nextInt();
		rectangle.setHeight(height);
		System.out.print("Enter width: ");
		int width=input.nextInt();
		rectangle.setWidth(width);
		System.out.println("Enter a colour: ");
		input.nextLine();
		String userColor=input.nextLine();
		try {
		rectangle.setColour(Color.valueOf(userColor.toUpperCase()));
		}
		catch(Exception e) {
			rectangle.setColour(Color.RED);
		}

	}
		
	}


