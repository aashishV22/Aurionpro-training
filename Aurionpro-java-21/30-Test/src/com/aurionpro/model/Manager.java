package com.aurionpro.model;

public class Manager extends Employee
{

	public Manager(long employeeId, String employeename, double basicSalary) 
	{
		super(employeeId, employeename, basicSalary);
		
	}

	@Override
	public double annualCTC(double basic, Employee user) {
		hra=(basic*25)/100;
		da=(basic*15)/100;
		ta=(basic*10)/100;
		annualCTC=basic;
		System.out.println("MANAGER: \nTotal basic annual salary is Rs-"+annualCTC);
		System.out.println("HRA is Rs-"+ hra);
		System.out.println("DA is Rs-"+ da);
		System.out.println("TA is Rs-"+ ta);
		System.out.print("Annual CTC is Rs-");
		annualCTC=basic+hra+da+ta;
		return annualCTC;
	}
		


}
