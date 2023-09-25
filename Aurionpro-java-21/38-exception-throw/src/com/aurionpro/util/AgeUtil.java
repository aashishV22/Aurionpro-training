package com.aurionpro.util;

import com.aurionpro.invalidException.InvalidAgeException;

public class AgeUtil 
{
	public static void validateAge(int age) throws InvalidAgeException{
		if(age>=18) {
			System.out.println("Eligible for voiting");
		}
		else {
//			throw new RuntimeException("Invalid age");
			throw new InvalidAgeException("invalid age");
		}
	}
	

}
