package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventory 
{
	private List<Guitar> guitars=new ArrayList<Guitar>();

	
	public void getInventory() {
		System.out.println(guitars);
	}
	
	public void addGuitar(String srNumber,double price,String builder,String model,String type,String backWood,String topWood) 
	{
		guitars.add(new Guitar(srNumber,price,builder,model,type,backWood,topWood));
	};

	public List<Guitar> getGuitar(String srNumber) 
	{
		List<Guitar> getGuitarBySrNumber = guitars.stream()
			.filter((guitar)->guitar.getSerialNumber().equals(srNumber))
			.collect(Collectors.toList());
		return getGuitarBySrNumber;
	}
	
	public void searchGuitar(Guitar searchGuitar) {
		boolean isFound=false;
		for(Guitar guitarOG:guitars) {
			if(searchGuitar.getBuilder().equalsIgnoreCase(guitarOG.getBuilder()) && searchGuitar.getModel().equalsIgnoreCase(guitarOG.getModel()) && searchGuitar.getType().equalsIgnoreCase(guitarOG.getType()) && searchGuitar.getBackWood().equalsIgnoreCase(guitarOG.getBackWood()) && searchGuitar.getTopWood().equalsIgnoreCase(guitarOG.getTopWood())) {
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				System.out.println(guitarOG);
				isFound=true;
			}
		}
		if(isFound==false) {
			System.out.println("Sorry, we have nothing in inventory for you!");
		}
	}


}
