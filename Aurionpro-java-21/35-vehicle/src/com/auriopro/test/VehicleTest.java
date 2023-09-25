package com.auriopro.test;
import java.time.LocalDate;

import com.auriopro.model.*;

public class VehicleTest 
{	
	public static void main(String[] args) 
	{
		IMovable[] movables= {
				new Car("wagonar",LocalDate.of(2020, 01, 14)),
				new Bike("Splendor",LocalDate.of(2011, 11, 14)),
				new Bus("Volvo",LocalDate.of(2023, 9, 23)),
		};
		for(int i=0;i<movables.length;i++) 
			{
				startMoving(movables[i]);
				//movables[i].showTopSpeed();
			}
	}

	private static void startMoving(IMovable movables) {
		System.out.println(movables);
		Vehicle obj=(Vehicle)movables;
		obj.showTopSpeed();
		movables.move();
	}
}


