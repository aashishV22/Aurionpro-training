package com.aurionpro.model;

public class PrintSlip 
{
	public void printSalarySlip(Employee employee) {
		double tax=new TaxUtil().calculateTax(employee)/12;
		TotalMonthSalary salary=new TotalMonthSalary();

		System.out.println("Id : "+employee.getEmployeeID());
		System.out.println("Name : "+employee.getEmployeeName());
		System.out.println("Basic "+employee.getEmpSalary());
		System.out.println("Hra "+employee.getHra());
		System.out.println("DA "+employee.getDa());
		System.out.println("TA "+employee.getTa());
		System.out.println("Total Monthly Salary "+salary.calculateTotalSalary(employee));
		System.out.println("Tax "+tax);
//		System.out.println("Net Monthly salary "+(salary.calculateTotalSalary(employee)
//				-tax/12));
	}
}
