package com.aurionpro.model;

public abstract class Employee {
	protected long employeeId;
	protected String employeename;
	protected double basicSalary;
	protected double annualCTC;
	protected double hra;
	protected double da;
	protected double ta;
	protected double pa;
	protected double ot;
	protected double ma;
	
	
	public Employee(long employeeId, String employeename, double basicSalary) {
		super();
		this.employeeId = employeeId;
		this.employeename = employeename;
		this.basicSalary = basicSalary;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getAnnualCTC() {
		return annualCTC;
	}
	public void setAnnualCTC(double annualCTC) {
		this.annualCTC = annualCTC;
	}

	public abstract double annualCTC(double basic,Employee user);
	

}
