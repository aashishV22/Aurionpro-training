package com.aurionpro.model;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class MovieController 
{
	MovieManager manager;
	
	public MovieController() 
	{
		manager =new MovieManager();
	}

	public void start(int id) 
	{
		Scanner sc=new Scanner(System.in);
	switch(id) 
		{
	
			case 1:
				try 
				{
					System.out.print("Enter movie Id: ");
					int movieId=sc.nextInt();	
					System.out.print("Enter movieName: ");
					sc.nextLine();
					String movieName=sc.nextLine();
					System.out.print("Enter movie-year: ");
					int movieYear=sc.nextInt();
					System.out.print("Enter movie-Genre: ");
					sc.nextLine();
					String movieGenre=sc.nextLine();
					
					manager.addMovies(new Movie(movieId,movieName,movieYear,movieGenre));
					break;
				}	catch (InputMismatchException  e) 	{		System.out.println("Enter a valid input format")			   ;	} 
					catch (NumberFormatException e) 	{		System.out.println("You entered a number instead of a string.");	}
					catch (Exception e) 				{	    System.out.println(e.getMessage())    						   ;	}

				
			case 2:
				System.out.println(manager.getMovies()); 
				break;
			case 3:
				manager.clearMovies();
				break;
			case 4:
				System.out.println("Getting movie by ID-");
				System.out.print("Enter Movie-ID: ");
				int movieID=sc.nextInt();
				manager.getMovieById(movieID);
				break;
			case 5:
				System.out.println("Deleting movie by ID-");
				System.out.print("Enter the movie-ID which is to be deleted: ");
				int movieIdInput=sc.nextInt();
				manager.deleteMovieById(movieIdInput);
				break;
		}
	}
	

}
