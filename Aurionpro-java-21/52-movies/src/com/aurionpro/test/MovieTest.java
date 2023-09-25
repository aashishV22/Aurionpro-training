package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.MovieController;

public class MovieTest 
{
	public static void main(String[] args) {
		MovieController controller=new MovieController();
		boolean isTaskEnded=false;
		while(!isTaskEnded) 
		{
			System.out.println("Enter: \n1 to add movies \n2 to get all Movies \n3 to clear all movies \n4 to get movie by ID \n5 to delete movie by ID \n0 to stop the task ");
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			
			if(input !=0) 
				{	controller.start(input);	}
			else{	isTaskEnded=true;
					System.out.println("Task stopped!");
			}
		}
	}
}
