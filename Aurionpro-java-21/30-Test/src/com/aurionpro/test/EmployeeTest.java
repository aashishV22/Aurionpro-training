package com.aurionpro.test;
import com.aurionpro.model.*;
public class EmployeeTest 
{
	public static void main(String[] args) 
	{
	Employee manager=new Manager(212,"Aju",800000)	;
	printSalarySlip(manager);
	System.out.println("\n -------------------------");
	Employee developer=new Developer(214,"AAShish",500000);
	printSalarySlip(developer);
	System.out.println("\n -------------------------");
	Employee accountant=new Accountant(21,"sdasd",300000);
	printSalarySlip(accountant);
	}

	private static void printSalarySlip(Employee emp) {
		double basic=emp.getBasicSalary();
		System.out.print(emp.annualCTC(basic,emp));
	}
}
