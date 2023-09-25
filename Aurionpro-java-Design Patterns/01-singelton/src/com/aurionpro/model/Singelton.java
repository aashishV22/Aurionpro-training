package com.aurionpro.model;

public class Singelton 
{
	private static Singelton singelton;
	private Singelton() {}
	
	public static Singelton getSingeltonInstance() {
		if(singelton==null) {
			singelton=new Singelton();
		}
		return singelton;
	}
	
	public void printGreetings() {
		System.out.println(this.hashCode()+":-Welcome");
	}
}
		