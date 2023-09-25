package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.invalidException.InvalidAgeException;
import com.aurionpro.util.AgeUtil;

public class ValidateAgeTest 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your age: ");
		int age =sc.nextInt();
		//AgeUtil.validateAge(age);
	try {
		AgeUtil.validateAge(age);
	}
	catch(InvalidAgeException e)
		{
//		 e.printStackTrace();
		System.out.println(e.getMessage());
		}
	}
}
