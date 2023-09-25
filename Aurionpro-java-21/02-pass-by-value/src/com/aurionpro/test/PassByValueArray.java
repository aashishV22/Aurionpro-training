package com.aurionpro.test;

public class PassByValueArray {
	public static void main(String[] args) {
		int[] numbers= {10,20,30,40,50,60};
		//System.out.println(numbers);
		incrementNumber(numbers);
		//System.out.println(numbers);
		for(int x:numbers)
		{
			System.out.println(x);
		}
	}
	private static void incrementNumber(int[] numbers) 
	{
		for (int x:numbers) 
		{
			x=x+1;
			System.out.println(x);
		}
	}
}

