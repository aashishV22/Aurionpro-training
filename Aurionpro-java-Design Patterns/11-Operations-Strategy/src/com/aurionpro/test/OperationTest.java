package com.aurionpro.test;


import com.aurionpro.model.*;

public class OperationTest 
{
	public static void main(String[] args) {
		OperationStrategy op=new OperationStrategy(new AddOperation());
		System.out.println(op.doOperation(2, 3));
		op.setOperation(new MultiplyOperation());
		System.out.println(op.doOperation(2, 3));
		
	}
}
