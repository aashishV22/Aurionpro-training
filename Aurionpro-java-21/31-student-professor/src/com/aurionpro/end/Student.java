package com.aurionpro.end;

import java.time.LocalDate;

public class Student extends Person
{

	public Student(int id, String address, LocalDate dOb) {
		super(id, address, dOb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString()+ "Student [id=" +getId()+ ", address=" + getAddress() + ", dOb=" + getdOb() + "]";
	}
	
	
}
