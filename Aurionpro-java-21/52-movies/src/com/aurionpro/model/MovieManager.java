package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MovieManager 
{
	List<Movie> movies;
	static final String filePath="D:\\Aurionpro-java-21\\52-movies\\movies.txt";
	public	MovieManager(){
		movies=new ArrayList();
		loadMovies();
	}

	public void addMovies(Movie movie) 
	{
		boolean isMoviePresent=false;
		for(Movie x:movies) 
		{
			if(movie.getId()==x.getId()) 
			{
				System.out.println("movie-ID already registered");
				isMoviePresent=true;
				break;
			}
		}
		if(!isMoviePresent) 
		{
			movies.add(movie);
			System.out.println(movie);
			saveMovies();
		}
	}
	
	public List<Movie> getMovies() {
		
		return movies;
	}
	
	public void clearMovies() {
		movies.clear();
		saveMovies();
	}
	
	public void getMovieById(int movieID) 
	{
		for(Movie x: movies) 
		{
			if(x.getId()==movieID) 
			{
				System.out.println(x);
			}
		}
	}
	
	public void deleteMovieById(int movieIdInput) {
		for(Movie x: movies) 
		{
			if(x.getId()==movieIdInput) 
			{
				System.out.println("Movie to be deleted is: "+x);
				movies.remove(x);
				saveMovies();
				break;
			}
		}
	}
	
	
	
	//Deserialization
	public void loadMovies() 
	{
			try 
			{
				FileInputStream file = new FileInputStream(filePath);
			      int b = file.available();
			      if (b != 0) {
			        ObjectInputStream in = new ObjectInputStream(file);
					movies=(List<Movie>)in.readObject();
					in.close();
			      }
			      file.close();
//				for(Movie x : movies) {
//					System.out.println(x);
//				}
				
			}
			
				catch (FileNotFoundException  e) 	{				e.printStackTrace();			} 
				catch (IOException 			  e) 	{				e.printStackTrace();			} 
				catch (ClassNotFoundException e) 	{				e.printStackTrace();			}
	}
	
	// Serialization
	public void saveMovies() {
			try 
			{
				OutputStream file = new FileOutputStream(filePath);
				ObjectOutputStream out=new ObjectOutputStream(file);
				out.writeObject(movies);
				out.close();
				file.close();
			} 	
				catch (FileNotFoundException  e) 	{				e.printStackTrace();			} 
				catch (IOException e) 		 	  	{				e.printStackTrace();			} 
	}
}

