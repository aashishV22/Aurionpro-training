package com.aurionpro.model;

public class LaptopBuilder 
{
	private Laptop laptop;
	public  LaptopBuilder() 
	{
		super();
		this.laptop=new Laptop();
	}
	
	
	public LaptopBuilder addID(int id) 
	{
		this.laptop.setId(id);
		return this;
	}
	public LaptopBuilder addBrand(String brand) 
	{
		this.laptop.setBrand(brand);
		return this;
	}
	public LaptopBuilder addHdd(String hdd) 
	{
		this.laptop.setHdd(hdd);
		return this;
	}
	public LaptopBuilder addRam(String ram) 
	{
		this.laptop.setRam(ram);
		return this;
	}
	public LaptopBuilder addTouchScreen(boolean value) 
	{
		this.laptop.setTouchScreen(value);
		return this;
	}
	public LaptopBuilder addProcessor(String processor) 
	{
		this.laptop.setProcessor(processor);
		return this;
	}
	public Laptop build() 
	{
		return this.laptop;
	}
	
	
}
