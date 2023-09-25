package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.aurionpro.model.Employee;

public class EmployeeTest 
{
	public static void main(String[] args) 
	{
		List<Employee> employees=new ArrayList();
		employees.add(new Employee(313,"aashish",13231,"Developer"));
		employees.add(new Employee(314,"Vedang",132334,"Developer"));
		employees.add(new Employee(315,"Tanish",1323132,"HR"));
		employees.add(new Employee(316,"Sid",1321,"HR"));
		
		
		List<Employee> hrEmployees = employees.stream()
			.filter((employee)->employee.getDepartment().equals("HR"))
			.collect(Collectors.toList());
		System.out.println(hrEmployees);
		
				
		Map<String, List<Employee>> collect=employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
				
		collect.forEach((key,value)->{
			System.out.println(key+"--"+value);
		});
		
		
		
		
	}
	
}
