package com.aurionpro.test;

import com.aurionpro.model.IAddable;

public class AdditionTest 
{
	public static void main(String[] args) {
		IAddable additionTest =new IAddable() {
			@Override
			public int addition(int a,int  b) {
				System.out.print("Addition is ");
				return a+b;
			}
		};
		System.out.println(additionTest.addition(10,5));
		
		IAddable additionInterface=(x,y)->
		{
			System.out.print("Addition is ");
			return x+y;
		};
		System.out.println(additionInterface.addition(3,6));
	
		
		
		IAddable subtraction1=AdditionTest::subtraction;
		System.out.println(subtraction1.addition(4,3));
	}
	
	public static int  subtraction(int a ,int b) {
		return a-b;
		
	}
}
