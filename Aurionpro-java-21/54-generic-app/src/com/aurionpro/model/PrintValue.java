package com.aurionpro.model;

public class PrintValue <T>{

	private T value;

	public PrintValue(T value) {
		super();
		this.value = value;
	}
	
	public void printMessage() {
		System.out.println(value);
	}
}
