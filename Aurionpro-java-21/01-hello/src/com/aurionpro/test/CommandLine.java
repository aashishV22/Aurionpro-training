package com.aurionpro.test;

public class CommandLine 
{
	public static void main(String[] args)
	{
		int sum=0;
		int firstNumber=0;
		for(int i=0;i<args.length;i++)
		{
			
			firstNumber= Integer.parseInt(args[i]);
			sum = sum+firstNumber;
			
		}
		System.out.println("the sum is "+sum);
	}	
}
