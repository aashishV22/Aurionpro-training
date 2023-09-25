package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Student 
{
	private int rollNumber;
	private String name;
	private double percentage;
	private List<String> hobbies=new ArrayList();
	public Student(int rollNumber, String name, double percentage, List<String> hobbies) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.percentage = percentage;
		this.hobbies = hobbies;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", percentage=" + percentage + ", hobbies="
				+ hobbies + "]";
	}
	
}
