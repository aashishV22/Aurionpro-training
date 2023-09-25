package com.aurionpro.test;

public class SecondLargestArray 
{	
	public static void main(String[] args)
	{
		int firstNumber=0;
		int largest=0;
		int secondLargest=0;
		for(int i=0;i<args.length;i++)
		{
			
			firstNumber=Integer.parseInt(args[i]);
			if(firstNumber>largest)   /// 20>0, 30>20 , 10>30, 40>30, 35>40
			{	
				secondLargest=largest; ///0,20,30
				largest=firstNumber;  ///30,40
			
			}
			if(firstNumber>secondLargest && firstNumber<largest)/// 30>30 and 35<40
			{
				secondLargest=firstNumber;  // 30
			}
		}
		System.out.println(secondLargest);
	}
}
