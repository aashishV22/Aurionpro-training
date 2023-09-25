package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.model.Student;

public class studentTest 
{
	public static void main(String[] args) 
	{
		List<Student> students=new ArrayList();
		students.add(new Student(23,"aashish", 70,Arrays.asList("drawing","reading","local Travel")));
		students.add(new Student(24,"vedang",  80,Arrays.asList("cricket","valorant","local Travel")));
		students.add(new Student(25,"tanish",  90,Arrays.asList("Youtube","anime","games")));
		students.add(new Student(26,"sid",     77,Arrays.asList("sleeping","reading","local Travel")));
		
		
		//Percentage top 3
		
		List<String>	hobbiesList = students.stream()
			.map((student)->student.getHobbies())
			.flatMap((list)->list.stream())
			.distinct()
			.collect(Collectors.toList());
		System.out.println(hobbiesList);
	
	}
}
