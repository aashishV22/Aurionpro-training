package com.aurionpro.test;

import com.aurionpro.model.Table;

public class TableTest {
	public static void main(String[] args) {
		Table answer=new Table(5);
		Thread t1=new Thread(answer);
		t1.start();
		
//		Table answer2=new Table(10);
		answer.setNumber(10);
		Thread t2=new Thread(answer);
		t2.start();
			
	}
}
