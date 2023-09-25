package com.aurionpro.model;

public class Accountant extends Employee {

	public Accountant(long employeeId, String employeename, double basicSalary) {
		super(employeeId, employeename, basicSalary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double annualCTC(double basic, Employee user) {
		hra=(basic*25)/100;
		ma=(basic*20)/100;
		annualCTC=basic;
		System.out.println("Total basic annual salary is Rs-"+annualCTC);
		System.out.println("HRA is Rs-"+ hra);
		System.out.println("MA is Rs-"+ ma);
		System.out.print("Annual CTC is Rs-");
		annualCTC=basic+hra+ma;
		return annualCTC;
	}

}
