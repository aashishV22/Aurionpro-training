package com.aurionpro.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class peopleTest 
{
	public static void main(String[] args) {
		 String[] names= {"Jay","Nimesh","Mark","Mahesh","Ramesh"};
		 Stream<String> stream = Arrays.stream(names);
		 stream.forEach((peopleName)->System.out.println(peopleName));
		 
		 System.out.println("----------------------------------");
		 List<String> namesList = Arrays.asList(names);
		 namesList.forEach((name)->System.out.println(name));
	
		 System.out.println("----------------------------------");
		 BufferedReader br=null;
			try
			{
	 			br=new BufferedReader(new FileReader("D:\\Aurionpro-java-21\\60-homeWork\\src\\name"));
				String line=br.readLine();
				while (line != null) 
				{
					System.out.println(line);
					line = br.readLine();
				}
			}catch(IOException e)			{		e.printStackTrace();	}
	

			 System.out.println("----------------------------------");
			 System.out.println("Names in file useing stream");			 
			 try
				{
				 	Stream<String>	nameInFile=	Files.lines(Paths.get("D:\\Aurionpro-java-21\\60-homeWork\\src\\name"));
				 	nameInFile.forEach((name)->System.out.println(name));
					
				 	
//					Stream<String>nameInFile= namesOfFile.stream();
//					nameInFile.forEach((name)->System.out.println(name));
					
				}catch(IOException e)			{		e.printStackTrace();	}
			 System.out.println("----------------------------------");
	 
			 String[] names1= {"Aashish","Jay","Nimesh","Mark","Mahesh","Ramesh"};
			 Arrays.stream(names1)
			 	.sorted()
			 	.limit(3)
		 		.forEach((name)->System.out.println(name));
			System.out.println("-----------------------------------top 3-Only contains 'a' ");
			 Arrays.stream(names1)
			 	.sorted()
			 	.filter((name)->name.contains("a"))
			 	.limit(3)
		 		.forEach((name)->System.out.println(name));
//			 System.out.println("-----------------------------Sorted in reverse ");
//			 Arrays.stream(names1)
//			 	.sorted(Collections.reverseOrder())
//			 	.limit(3)
//		 		.forEach((name)->System.out.println(name));
			 System.out.println("------------------------------");
//			 Arrays.stream(names1)
//			     .map(name -> name.substring(0, 3))
//			     .forEach(System.out::println);

			 System.out.println("--------------------------------");
			 Arrays.stream(names1)
			 	.sorted()
			 	.filter((name)->name.length()<4)
			 	.forEach((name)->System.out.println(name));
			 
			 System.out.println("----------------------------------");
			 List<Integer> numbers=Arrays.asList(10,20,30,40,50,25,35,45);
			 Integer sorted = numbers.stream()
					 .min(Comparator.comparingInt(Integer::	)).get();

			 
			 
	}
}
