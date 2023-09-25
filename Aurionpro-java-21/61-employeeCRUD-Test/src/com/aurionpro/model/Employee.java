package com.aurionpro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Employee implements Serializable
{
	private int employeeID;
	private String employeeName;
	private String employeeDesignation;
	private LocalDate dateOfJoining;
	private int employeeManager;
	private int employeeSalary;
	private int employeeCompensation;
	private int employeeDepartmentId;
	private static final long serialVersionUID=1L;

	public Employee(int employeeID, String employeeName, String employeeDesignation, LocalDate dateOfJoining,
			int employeeManager, int employeeSalary, int employeeCompensation, int employeeDepartmentId) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.dateOfJoining = dateOfJoining;
		this.employeeManager = employeeManager;
		this.employeeSalary = employeeSalary;
		this.employeeCompensation = employeeCompensation;
		this.employeeDepartmentId = employeeDepartmentId;
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
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public int getEmployeeManager() {
		return employeeManager;
	}
	public void setEmployeeManager(int employeeManager) {
		this.employeeManager = employeeManager;
	}
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public int getEmployeeCompensation() {
		return employeeCompensation;
	}
	public void setEmployeeCompensation(int employeeCompensation) {
		this.employeeCompensation = employeeCompensation;
	}
	public int getEmployeeDepartmentId() {
		return employeeDepartmentId;
	}
	public void setEmployeeDepartmentId(int employeeDepartmentId) {
		this.employeeDepartmentId = employeeDepartmentId;
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeDesignation="
				+ employeeDesignation + ", dateOfJoining=" + dateOfJoining + ", employeeManager=" + employeeManager
				+ ", employeeSalary=" + employeeSalary + ", employeeCompensation=" + employeeCompensation
				+ ", employeeDepartmentId=" + employeeDepartmentId + "]\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(employeeID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeID == other.employeeID;
	}
	
	
	
	
}
