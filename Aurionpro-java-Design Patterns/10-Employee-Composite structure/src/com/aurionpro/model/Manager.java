package com.aurionpro.model;

public class Manager implements IEmployee
{

	@Override
	public void showEmployeeDetails() {
		System.out.println("Name:-"+name+" ,position:-"+position);
	}

	private String name;
	private String position;
	public Manager(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Manager [name=" + name + ", position=" + position + "]";
	}
	
	
}
