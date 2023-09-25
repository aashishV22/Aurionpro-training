package com.aurionpro.model;

public class Child extends Parent{
	public Child(){
		super(0);
		System.out.println("Inside Child Constructor");
//	super();   it should always be in first line
	}
}
