package com.aurionpro.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.aurionpro.model.CountryInfo;

public class CountryCodeTest 
{
	public static void main(String[] args) 
	{
		BufferedReader br=null;
		Map<String,CountryInfo> country = new HashMap<String,CountryInfo>();
		Scanner sc=new Scanner(System.in);
		try
		{
 			br=new BufferedReader(new FileReader("D:\\Aurionpro-java-21\\50-countaryCodes\\src\\com\\aurionpro\\test\\country.txt"));
			String line=br.readLine();
			while (line != null) 
			{
				String[] countryArray = line.split(",");
				String key1=countryArray[0].trim().replaceAll("\"", "");
				String value1=countryArray[1].trim().replaceAll("\"", "");
				int value2=Integer.parseInt(countryArray[2].trim());
				country.put(key1,new CountryInfo(value1,value2));
				line = br.readLine();
			}
//			country.forEach((key,value)->
//			{
//				System.out.println(key+" "+value);
//			});
		}catch(IOException e) 
			{
				e.printStackTrace();
			}
		System.out.print("Enter code");
		String input=sc.next();
		for(Entry<String, CountryInfo> entery:country.entrySet()) 
			{
				if(entery.getKey().equalsIgnoreCase(input)) 
					{
						System.out.println("Country code is "+entery.getKey());
						System.out.println(entery.getValue());
						System.out.println("-----------------------");
					}
			}
		System.out.print("Enter Country name:");
		String countryNameInput=sc.next();
		for(Entry<String, CountryInfo> entry:country.entrySet()) 
		{
			if(entry.getValue().getCountryName().equalsIgnoreCase(countryNameInput)) 
				{
					System.out.println("Country name is "+entry.getValue().getCountryName());
					System.out.println("Region  code is " +entry.getValue().getRegion());
					System.out.println("-----------------------");
				}
		}
		
	System.out.print("Enter Region code: ");
	int regionInput=sc.nextInt();
	
	
	}
	
	
	
	
}