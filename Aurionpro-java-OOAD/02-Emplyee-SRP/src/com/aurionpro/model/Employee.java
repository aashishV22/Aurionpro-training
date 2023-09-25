package com.aurionpro.model;

public class Employee 
{
	public int 	  employeeID;
	public String employeeName;
	public double empSalary;
	public double hra;
	public double da;
	public double ta;
	public double annualTaxSalary;
	public double totalMonthSalary;
	public Employee(int employeeID, String employeeName, double empSalary) {
		super();
		this.employeeID   = employeeID;
		this.employeeName = employeeName;
		this.empSalary    = empSalary;
		this.hra		  =	((empSalary*20)/100);
		this.da		  	  =	((empSalary*15)/100);
		this.ta			  =	((empSalary*10)/100);
	}
	
	
	
	
	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public double getEmpSalary() {
		return empSalary;
	}


	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}


	public double getHra() {
		return hra;
	}


	public void setHra(double hra) {
		this.hra = hra;
	}


	public double getDa() {
		return da;
	}


	public void setDa(double da) {
		this.da = da;
	}


	public double getTa() {
		return ta;
	}


	public void setTa(double ta) {
		this.ta = ta;
	}


	public double getAnnualTaxSalary() {
		return annualTaxSalary;
	}


	public void setAnnualTaxSalary(double annualSalary) {
		this.annualTaxSalary = annualSalary;
	}


	public double getToatlMonthSalary() {
		return totalMonthSalary;
	}


	public void setToatlMonthSalary(double toatlMonthSalary) {
		this.totalMonthSalary = toatlMonthSalary;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", empSalary=" + empSalary
				+ ", hra=" + hra + ", da=" + da + ", ta=" + ta + ", annualTaxSalary=" + annualTaxSalary
				+ ", totalMonthSalary=" + totalMonthSalary + "]";
	}

	
	
}
