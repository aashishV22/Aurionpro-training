package com.aurionpro.test;
import java.util.*;
public class Factorial {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int firstInput= input.nextInt();
		int start=1;
		int factorial=1;
		for(int i=1;i<=firstInput;i++)
		{
			factorial=factorial*i;
		}
		System.out.println("Factorial of "+firstInput+" is "+factorial);

	}

}
