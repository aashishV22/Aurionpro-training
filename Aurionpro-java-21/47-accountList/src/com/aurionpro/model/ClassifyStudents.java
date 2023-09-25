package com.aurionpro.model;
import java.util.ArrayList;
import java.util.List;


public class ClassifyStudents 
{
	static Student maxPercentage= new Student();
	public static Student getMaxPercentage(List<Student> students)
	{
		maxPercentage=students.get(0);
		for(int i=0;i<((List<Student>)students).size();i++) 
		{
			if(maxPercentage.getPercentage()<students.get(i).getPercentage()) 
			{
				maxPercentage=students.get(i);
				
			}
		}
		return maxPercentage;
	}
	
	static Student minPercentage= new Student();
	public static Student getMinPercentage(List<Student> students)
	{
		minPercentage=students.get(0);
		for(int i=0;i<((List<Student>)students).size();i++) 
		{
			if(minPercentage.getPercentage()>students.get(i).getPercentage()) 
			{
				minPercentage=students.get(i);
				
			}
		}
		return minPercentage;
	}
}
