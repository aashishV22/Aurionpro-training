package com.aurionpro.model;

public interface IRepository 
{
	void create();
	void read();
	public default void update() 
	{
		System.out.print("Product is updating");
	}
	public static void delete() {
		System.out.println("Product is Deleted");
	}
	int varities=42;
	
}
