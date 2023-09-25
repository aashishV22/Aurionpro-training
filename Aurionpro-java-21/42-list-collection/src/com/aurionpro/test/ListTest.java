
package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List <Integer> numbers=new ArrayList<Integer>();
//		List <Integer> numbers=new ArrayList<>();
//		List<> numbers1=new ArrayList<>();   //   Not rigth syntax
//Add
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
//contains
		System.out.println(numbers.contains(30));
		System.out.println(numbers.contains(4));
		System.out.println(numbers);
		
// remove
		numbers.remove(new Integer(20));
//		numbers.remove(1);
		System.out.println(numbers);
		
		//Size
		System.out.println(numbers.size());
		
		//clear
		numbers.clear();
		System.out.println(numbers);
		
	}
}
