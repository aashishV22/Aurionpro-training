package com.aurionpro.test;
import com.aurionpro.model.*;

public class SingeltonTest {
	public static void main(String[] args) {
		Singelton obj1= Singelton.getSingeltonInstance();
		obj1.printGreetings();

		Singelton obj2= Singelton.getSingeltonInstance();
		obj2.printGreetings();
		System.out.println(obj1==obj2);
	}
	
	
}
