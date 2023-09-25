package com.aurionpro.model;

public class Employee 
{
	private int     employeeID;
	private String  emplyeeName;
	private double  employeeSalary;
	private String  Department;
	public Employee(int employeeID, String emplyeeName, double employeeSalary, String department) {
		super();
		this.employeeID = employeeID;
		this.emplyeeName = emplyeeName;
		this.employeeSalary = employeeSalary;
		Department = department;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmplyeeName() {
		return emplyeeName;
	}
	public void setEmplyeeName(String emplyeeName) {
		this.emplyeeName = emplyeeName;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", emplyeeName=" + emplyeeName + ", employeeSalary="
				+ employeeSalary + ", Department=" + Department + "]";
	}
	
}
