package com.aurionpro.test;
import com.aurionpro.model.*;
import java.util.Scanner;
public class CustomerTest 
{
	public static void main(String[] args) 
	{
		Customer[] customer1=new Customer[5];
		for (int i = 0; i < customer1.length; i++) 
		{
			customer1[i] = new Customer();
			System.out.println(customer1[i]);
		}
		System.out.println("Enetr Details");
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < customer1.length; i++) 
		{
			System.out.print("Enter customerID:");
			customer1[i].setCustomerID(sc.nextInt());
			System.out.print("Enter Name:");
			customer1[i].setName(sc.next());
			System.out.print("Enter Email-ID:");
			customer1[i].setEmail(sc.next());
			System.out.print("Enter Password:");
			customer1[i].setPassword(sc.nextInt());
		}
		for (int i = 0; i < customer1.length; i++) {
			if (validateEmail(customer1[i]) == true)
				System.out.println("Valid email customers are:");
				System.out.println(customer1[i]);
		}
		System.out.println("*********************\n After Sorting by name:");
		sortArray(customer1);
		for (int i = 0; i < customer1.length; i++) 
		{
			System.out.println(customer1[i]);
		}
	}
	
	private static void sortArray(Customer[] customer) 
	{
		Customer temp = null;
		 for (int i = 0; i < customer.length; i++) 
		 {
			for (int j = 0; j < customer.length; j++) 
			{
				if(customer[i].getName().compareToIgnoreCase(customer[j].getName())<0) 
				{
					temp = customer[i];
					customer[i]=customer[j];
					customer[j]=temp;			
				}
			}
		 }
	}
	public static boolean validateEmail(Customer customer1) 
	{
		int check1 = 0, check2 = 0, check3=0;
		check1 = customer1.getEmail().indexOf("@");
		check3 = customer1.getEmail().indexOf("gmail");
		check2 = customer1.getEmail().indexOf(".com");
		if (check1 != -1 && check2 != -1 && check3!=-1) 
		{
			return true;
		}
		return false;
	}

	
	
	
}