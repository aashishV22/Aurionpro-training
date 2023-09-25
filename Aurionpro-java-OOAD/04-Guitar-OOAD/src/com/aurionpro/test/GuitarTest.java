package com.aurionpro.test;

import com.aurionpro.model.*;

public class GuitarTest 
{
	public static void main(String[] args) 
	{
//		Guitar( serialNumber,  price,  builder,  model,  type,  backWood,
//				 topWood)
		
		Inventory inventory=new Inventory();
		inventory.addGuitar("ddw232",32322,new GuitarSpec(Builder.ANNI    ,	"edm", Type.ELECTRIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD,12));
		inventory.addGuitar("1", 	 200,  new GuitarSpec(Builder.COLLINGS, "Aris",Type.ACOUSTIC, Wood.ALDER, Wood.ALDER	,12));
		inventory.addGuitar("2", 	 700,  new GuitarSpec(Builder.FENDER  , "A1",  Type.ELECTRIC, Wood.CEDAR, Wood.ALDER	,12));
		inventory.addGuitar("3", 	 900,  new GuitarSpec(Builder.GIBSON  , "A1",  Type.ACOUSTIC, Wood.ALDER, Wood.CEDAR	,12));
		inventory.addGuitar("4",  	 100,  new GuitarSpec(Builder.OLSON   , "A1",  Type.ACOUSTIC, Wood.ALDER, Wood.INDIAN_ROSEWOOD	 ,12));
		inventory.addGuitar("5", 	 200,  new GuitarSpec(Builder.COLLINGS																										, "A1",  Type.ELECTRIC, Wood.CEDAR, Wood.MAPLE	,12));
		
		System.out.println("Print All guitar list: \n"+inventory.getInventory());
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		GuitarSpec customer=new GuitarSpec(Builder.COLLINGS, "Aris",Type.ACOUSTIC, Wood.ALDER, Wood.ALDER,12);
		inventory.searchGuitar(customer);
	
	
	}
}
