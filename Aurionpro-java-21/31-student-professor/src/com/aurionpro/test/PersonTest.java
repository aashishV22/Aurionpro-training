package com.aurionpro.test;
import com.aurionpro.end.*;
import java.time.LocalDate;
public class PersonTest 
{
	public static void main(String[] args) 
	{
	
	Person student1=new Student(12,"sdefewf",LocalDate.of(2002,01,01));
	System.out.println(student1);
	
	Professor professor1=new Professor(12,"fefee",LocalDate.of(2000, 02, 22),231313);
	System.out.println(professor1);
	}
}
