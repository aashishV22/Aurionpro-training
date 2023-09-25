package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;

import com.aurionpro.model.PrintValue;
import com.aurionpro.model.Rectangle;

public class PrintTest 
{

	public static void main(String[] args) {
		PrintValue<Integer> printObj1=new PrintValue<Integer>(10);
		PrintValue<Double> printObj2=new PrintValue<Double>(10.0);
		PrintValue<Rectangle> printObj3=new PrintValue<Rectangle>(new Rectangle(10));
		printObj1.printMessage();
		printObj2.printMessage();
		printObj3.printMessage();
	
// Generic methods
		printValues(10,new Rectangle(9));
		List<Integer> intList=Arrays.asList(10,20,30,40);
		printList(intList);
		List<Double> doubleList=Arrays.asList(10.4,20.5,30.6,40.7);
		printList(doubleList);	
		printList2(doubleList);
	};

//	private static <T> void printList(List<T> values) {
	private static void printList(List<?> values) {
		for(Object x:values) {
			System.out.println(x);
		}
	}
	
	private static <T> void printList2(List<T> values) {
			System.out.println(values);
	}
	

	private static <T,S> void printValues(T value1, S value2) {
		System.out.println(value1+"--"+value2);
		System.out.println(value1.getClass()+"--"+value2.getClass());
	}
}
