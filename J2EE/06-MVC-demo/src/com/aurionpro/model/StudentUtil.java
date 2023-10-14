package com.aurionpro.model;
import java .util.*;

public class StudentUtil 
{
	public List<Student> getAllStudents() {
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"niteshh K"  ,"nitesh@gmail.com"  ,75.0));
		students.add(new Student(2,"bhaveshh d" ,"bhavesh@gmail.com" ,65.0));
		students.add(new Student(3,"maheshh w"  ,"mahesh@gmail.com"  ,85.0));
		students.add(new Student(4,"jigneshh r" ,"jignesh@gmail.com" ,95.0));
		return students;
	}
}
