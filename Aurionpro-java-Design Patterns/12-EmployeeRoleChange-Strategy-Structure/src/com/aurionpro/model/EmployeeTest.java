package com.aurionpro.model;

import com.aurionpro.model.*;

public class EmployeeTest 
{
	public static void main(String[] args) {
		Employee emp1=new Employee(1, "aashish", new Consultant());
		System.out.println(emp1.getDescription());
		emp1.changeRole(new TechLead());
		System.out.println(emp1.getDescription());
		
	}
}
