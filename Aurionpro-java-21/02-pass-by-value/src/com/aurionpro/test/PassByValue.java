package com.aurionpro.test;

public class PassByValue 
{
		public static void main(String[] args) 
		{
			int number=1;
			System.out.println(number);
			incrementNumber(number);
			System.out.println(number);
		}
		private static void incrementNumber(int x)
		{
			x+=10;
		}
}
