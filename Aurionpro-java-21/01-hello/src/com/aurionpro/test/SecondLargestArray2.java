package com.aurionpro.test;

public class SecondLargestArray2 
{
	public static void main(String[] args)
	{
		int[] number=new int[args.length];
		for(int i=0;i<args.length;i++)
		{
			number[i]=Integer.parseInt(args[i]);
			System.out.println(number[i]);
		}
	}
}
