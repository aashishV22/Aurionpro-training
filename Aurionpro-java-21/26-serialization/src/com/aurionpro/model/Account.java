package com.aurionpro.model;
import java.io.Serializable;
public class Account implements Serializable
{	
	private int id;
	private String name;
	private int salary;
	private static final long serialVersionUID=1L;
	public Account(int id, String name, int salary) 
	{
		super();
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean deposit(double amount) {
		if(amount>0) {
			return true;
		}else
			return false;
	}
	public boolean withdraw(double amount,Account c1) {
		
		return true;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}
