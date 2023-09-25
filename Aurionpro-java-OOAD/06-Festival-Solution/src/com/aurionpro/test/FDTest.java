package com.aurionpro.test;

import com.aurionpro.model.DiwaliInterest;
import com.aurionpro.model.FixedDeposit;
import com.aurionpro.model.*;

public class FDTest 
{
	public static void main(String[] args) 
	{
		FixedDeposit fd1=new FixedDeposit(232432, "Aashish", 32000.3, 2, new DiwaliInterest());
//		System.out.println(fd1.calculateSimpleInterest());
//		System.out.println(fd1);
		fd1.calculateSimpleInterest();
		System.out.println(fd1);
		FixedDeposit fd2=new FixedDeposit(232432, "Aashish", 52000.3, 5, new HoliInterest());
		System.out.println(fd2);
		fd2.calculateSimpleInterest();
		System.out.println(fd2);
		
	}
}
