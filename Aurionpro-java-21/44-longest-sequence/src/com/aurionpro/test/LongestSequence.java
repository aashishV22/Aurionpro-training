package com.aurionpro.test;
import java.util.*;
public class LongestSequence 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String input;
		System.out.println("Enter a String");
		input=sc.next();
		char longestSequence=' ';
		int sequence=1;
		int maxCount=0;
		for(int i=0;i<input.length()-1;i++) 
		{
			char first = input.charAt(i);
			if(first == input.charAt(i+1)) 
			{
				sequence++;
				if(sequence>maxCount) 
				{
					longestSequence=first;
					maxCount=sequence;
				}
			}
			else 
			{
				sequence=1;
			}
		}
		System.out.println("Longest sequence is: "+longestSequence + " its count is: "+maxCount);
	}
}
