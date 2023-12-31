package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Directory implements IEmployee
{


	
	private List<IEmployee> employees;
	
	public Directory() {
		this.employees=new ArrayList<IEmployee>();
	}

	public void addEmployee(IEmployee employee) {
		this.employees.add(employee);
	}
	
	@Override
	public void showEmployeeDetails() {
//		System.out.println(this.employees);
		this.employees.forEach(employee->
			System.out.println(employee));
	}

	@Override
	public String toString() {
		return " employees=" + employees ;
	}

	public void removeEmployee(IEmployee employee) {
		if(this.employees.contains(employee)) {
			
		};
	}	
	
}
