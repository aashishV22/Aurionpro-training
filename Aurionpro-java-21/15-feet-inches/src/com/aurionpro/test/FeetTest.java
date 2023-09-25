package com.aurionpro.test;

import com.aurionpro.model.Feet;

public class FeetTest 
{
	public static void main(String[] args) 
	{
		
		Feet feet1=new Feet(3,10);
		Feet feet2=new Feet(7,8);
		System.out.println(additionFeet(feet1,feet2));
	}
	private static Feet additionFeet(Feet feet1, Feet feet2) 
	{	int inches=0;
		Feet addition=new Feet(0,0);
		addition.setInches(feet1.getInches()+feet2.getInches());
		if(addition.getInches()>=18) 
		{	
			inches+=1;
			addition.setInches(addition.getInches()-12);
		}
		addition.setFeet(feet1.getFeet()+feet2.getFeet()+inches);
		return addition;
	}

}
