package com.aurionpro.test;

import com.aurionpro.model.*;

public class EmployeeTest 
{
	public static void main(String[] args) {
		IEmployee dev1=new Developer("aashish", "trainee");
		IEmployee dev2=new Developer("vedang", "trainee");
		
		Directory devDirectory=new Directory();
		devDirectory.addEmployee(dev1);
		devDirectory.addEmployee(dev2);
		devDirectory.showEmployeeDetails();
		
		
		IEmployee man1=new Manager("tanish", "Manager");
		IEmployee man2=new Manager("nitesh", "Manager");
		
		Directory manDirectory=new Directory();
		manDirectory.addEmployee(man1);
		manDirectory.addEmployee(man2);
		manDirectory.showEmployeeDetails();
		
		Directory companyDirectory=new Directory();
		companyDirectory.addEmployee(devDirectory);
		companyDirectory.addEmployee(manDirectory);
		companyDirectory.showEmployeeDetails();
		
		companyDirectory.removeEmployee();
		
	}
}
