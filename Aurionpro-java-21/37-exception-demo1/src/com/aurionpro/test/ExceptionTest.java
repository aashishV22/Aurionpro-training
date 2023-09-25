package com.aurionpro.test;

public class ExceptionTest 
{	
	public static void main(String[] args) 
	{
		try 
		{
			int firstNumber=Integer.parseInt(args[0]);
			System.out.println("Enter first number");
			int secondNumber=Integer.parseInt(args[1]);
			System.out.println("Enter second number");
			int div=firstNumber/secondNumber;
			System.out.println("Division is ");
			System.out.println(div);
		}
		catch(ArithmeticException e) 
		{
			System.out.println("Number cannot be divided be zero");
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("Access to invalid index position");	
		}
		catch(NumberFormatException e) 
		{
			System.out.println("Access to invalid index position");	
		}
		catch(Exception e) 
		{
			System.out.println("Invaild number format");	
		}
		finally {
			System.out.println("Inside finally block");
		}
		System.out.println("Outside try catch");
	
	}

}
