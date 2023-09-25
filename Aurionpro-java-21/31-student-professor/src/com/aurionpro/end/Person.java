package com.aurionpro.end;

import java.time.LocalDate;

public abstract class Person 
{
	private int id;
	private String address;
	private LocalDate dOb;
	public Person(int id, String address, LocalDate dOb) {
		super();
		this.id = id;
		this.address = address;
		this.dOb = dOb;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getdOb() {
		return dOb;
	}
	public void setdOb(LocalDate dOb) {
		this.dOb = dOb;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", address=" + address + ", dOb=" + dOb + "]";
	}

	
	
	
}
