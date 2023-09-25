package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.aurionpro.model.ClassifyStudents;
import com.aurionpro.model.Student;

public class StudentTest 
{
	public static void main(String[] args) 
	{
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"Aashish",83));
		students.add(new Student(2,"Vedang",85));
		students.add(new Student(3,"Tanish",72));
		students.add(new Student(4,"Siddhant",82));
		students.add(new Student(5,"Suswar",92));
		students.add(new Student(6,"Aniket",77));
	
		ClassifyStudents obj=new ClassifyStudents();
		System.out.println("Minimum Percentage student is:-\n"+obj.getMaxPercentage(students));
//		for(Student x:students) {
//			System.out.println(x);
//		}
		System.out.println("Minimum Percentage student is:-\n"+obj.getMinPercentage(students));
		System.out.println("--------------------------------------------------------------");
		students.sort(Comparator.comparing(Student::getPercentage).reversed());
		for(Student x:students) {
			System.out.println(x);
		}
		
		System.out.println("--------------------------------------------------------------");
		students.sort(Comparator.comparing(Student::getStudentName));
		for(Student x:students) {
			System.out.println(x);
		}
	}	
}
