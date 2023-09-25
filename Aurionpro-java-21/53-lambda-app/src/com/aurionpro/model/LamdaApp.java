package com.aurionpro.model;

public class LamdaApp 
{
	public static void main(String[] args) {
		IGreetable welcome=new WelcomeGreeting();
		welcome.printMessage();

		IGreetable goodbye=new IGreetable() {
			
			@Override
			public void printMessage() {
				System.out.println("GoodBye");				
			}
		}; 
		goodbye.printMessage();
		
		//Functional Interface
		IGreetable functionalInterface=()->{
			System.out.println("functional Interface");
		};
		functionalInterface.printMessage();

		IGreetable hello=LamdaApp::helloMessage;
	
		hello.printMessage();
	}

	public static void helloMessage() {
		System.out.println("hello message");
	}

}
