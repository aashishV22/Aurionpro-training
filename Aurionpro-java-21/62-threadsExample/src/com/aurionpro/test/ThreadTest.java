package com.aurionpro.test;

import com.aurionpro.model.PrintNumber;

public class ThreadTest {
	public static void main(String[] args) {
		System.out.println("Inside main");
		PrintNumber t1=new PrintNumber();
		t1.start();
	
		PrintNumber t2=new PrintNumber();
		t2.start();
		t2.setPriority(6);
	
		System.out.println("Ende main");
	}
	
	
	
}
