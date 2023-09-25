package com.aurionpro.test;

import com.aurionpro.model.Employee;
import com.aurionpro.model.PrintSlip;
import com.aurionpro.model.TaxUtil;

public class EmployeeTest 
{
	public static void main(String[] args) 
	{
		Employee emp1=new Employee(1312,"AAshish",50000);
		System.out.println(emp1);
		TaxUtil tax=new TaxUtil();
		PrintSlip slip=new PrintSlip();
		System.out.println(tax.calculateTax(emp1));
//		System.out.println(emp1);
		System.out.println("--------------------------------");
		slip.printSalarySlip(emp1);
	}
}
