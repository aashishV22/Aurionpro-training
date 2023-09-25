package com.aurionpro.end;

import java.time.LocalDate;

public class Professor extends Person implements SalariedEmployee
{
	private double salary;
	public Professor(int id, String address, LocalDate dOb, double salary) {
		super(id, address, dOb);
		this.salary=salary;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double calculateSalary(double salary) 
	{
		this.salary=salary;
		return salary;	
	}

	@Override
	public String toString() {
		return "Professor [salary=" + salary + "]";
	}

}
