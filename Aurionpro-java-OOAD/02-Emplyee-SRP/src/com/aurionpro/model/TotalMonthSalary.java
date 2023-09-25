package com.aurionpro.model;

public class TotalMonthSalary {
	
	public double calculateTotalSalary(Employee employee) 
	{
		employee.setToatlMonthSalary(employee.getEmpSalary()+employee.getHra()+employee.getDa()+employee.getTa());
		return employee.getToatlMonthSalary();
	};
}
