package com.aurionpro.test;

import com.aurionpro.model.FestivalType;
import com.aurionpro.model.FixedDeposit;

public class FDTest 
{
	public static void main(String[] args) 
	{
		FixedDeposit fd1=new FixedDeposit(232432, "Aashish", 32000.3, 2, FestivalType.DIWALI);
		System.out.println(fd1.calculateSimpleInterest());
		System.out.println(fd1);
	}
}
