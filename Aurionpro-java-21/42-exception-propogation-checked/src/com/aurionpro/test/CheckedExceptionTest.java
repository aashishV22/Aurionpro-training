package com.aurionpro.test;

public class CheckedExceptionTest {
	public static void main(String[] args) {
		System.out.println("Main start");
		function1();
		System.out.println("Main End");
	}

	private static void function1() {
		System.out.println("function1 start");
		function2();
		System.out.println("function1 End");
	}

	private static void function2() {
		System.out.println("function2 start");
		try{
			function3();
		
		} catch(Exception e) {
			System.out.println("Exception Handeled in function 2");;
		}
		System.out.println("function2 End");
	}


	private static void function3() throws Exception{
		System.out.println("function3 start");
		try{
			function4();
		
		} catch(Exception e) {
			System.out.println("Exception Handeled in function 3");;
		}
		System.out.println("function3 End");
	}

	private static void function4() throws Exception{
		System.out.println("function4 start");
		throw new Exception();

		
	}
}
