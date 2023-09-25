package com.aurionpro.test;
import com.aurionpro.model.Student;
public class StudentTest {
	public static void main(String[] args)
	{
		Student student=new Student();
		student.id=121;
		student.name="mahesh";
		student.emailID="mahesh22@gmail.com";
		System.out.println("Id is "+student.id+" \nName is "+student.name);
		
		
	}
}
