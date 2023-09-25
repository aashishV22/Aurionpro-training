package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventory 
{
	private List<Guitar> guitars=new ArrayList<Guitar>();

	
	public List<Guitar> getInventory() {
		return guitars;
	}
	
	public void addGuitar(String srNumber,double price, GuitarSpec specs) 
	{
		guitars.add(new Guitar(srNumber,price,specs));
	}

	public List<Guitar> getGuitar(String srNumber) 
	{
		List<Guitar> getGuitarBySrNumber = guitars.stream()
			.filter((guitar)->guitar.getSerialNumber().equals(srNumber))
			.collect(Collectors.toList());
		return getGuitarBySrNumber;
	}
	
	public void searchGuitar(GuitarSpec searchGuitar) {
		boolean isFound=false;
		List<Guitar> results=new ArrayList<Guitar>();
		for(Guitar guitarOG:guitars) {
			if(searchGuitar.match(guitarOG.getSpecs())) 
			{
				results.add(guitarOG);
				isFound=true;
			}
		}
		if(isFound==false) {
			System.out.println("Sorry, we have nothing in inventory for you!");
		}
		if(isFound==true) 
		{
			System.out.println("We have these Guitars for you:");
			System.out.println(results);
		}
	}


}
