package com.aurionpro.model;

public class Employee 
{
	private int id;
	private String name;
	private IRole role;
	public Employee(int id, String name, IRole role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	public void changeRole(IRole role) {
		this.role=role;
	}
	public String getDescription() {
		return this.role.description();
	}
	public String getRole() {
		return this.role.responsibility();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
}
