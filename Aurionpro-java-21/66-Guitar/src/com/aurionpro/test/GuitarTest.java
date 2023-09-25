package com.aurionpro.test;

import com.aurionpro.model.*;

public class GuitarTest 
{
	public static void main(String[] args) 
	{
		Inventory inventory=new Inventory();
		inventory.addGuitar("ddw232",32322,"Aashish","Indian","edm","backwood","topWood");
		inventory.addGuitar("1", 20, "build", "Aries", "Guitar", "Alder", "Alder");
		inventory.addGuitar("2", 60, "build", "A2", "Guitar", "Black Limba", "Black Limba");
		inventory.addGuitar("3", 600, "build", "DC", "Guitar", "Walnut", "Walnut");
		inventory.addGuitar("4", 900, "build", "DC", "Guitar", "Walnut", "Walnut");
		inventory.addGuitar("5", 200, "build", "DC", "Guitar", "Walnut", "Walnut");
		System.out.println(inventory.getGuitar("ddw232"));
//		inventory.getInventory();
		Guitar customer=new Guitar("2",3232,"build","DC","Guitar","Walnut","walnut");
		inventory.searchGuitar(customer);
	}
}
