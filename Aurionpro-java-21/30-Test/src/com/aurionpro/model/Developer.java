package com.aurionpro.model;

public class Developer extends Employee{

	public Developer(long employeeId, String employeename, double basicSalary) {
		super(employeeId, employeename, basicSalary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double annualCTC(double basic, Employee user) {
		pa=(basic*40)/100;
		ot=(basic*20)/100;
		annualCTC=basic;
		System.out.println("DEVELOPER: \nTotal basic annual salary is Rs-"+annualCTC);
		System.out.println("PA is Rs-"+ pa);
		System.out.println("OT is Rs-"+ ot);
		System.out.print("Annual CTC is Rs-");
		annualCTC=basic+pa+ot;
		return annualCTC;
	}

}
