package com.aurionpro.model;

public class WelcomeGreeting implements IGreetable{

	@Override
	public void printMessage() {
		System.out.println("Welcome message");
	}
	
}
