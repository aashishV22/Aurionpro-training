package com.aurionpro.test;

import com.aurionpro.model.Feet;

public class FeetTest 
{
	public static void main(String[] args) 
	{
		
		Feet feet1=new Feet(4,10);
		Feet feet2=new Feet(7,18);
		Feet feet3=feet1.additionFeet(feet2);
		System.out.println(feet3);
	}


}
