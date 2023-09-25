package com.aurionpro.model;

public class Sales {
	private int id;
	private String name;
	private String state;
	private int experience;
	private int salesAmount;

	
	
	
	public Sales(int id, String name, String state, int experience, int salesAmount) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.experience = experience;
		this.salesAmount = salesAmount;
	}
	public void setID(int id) 
		{
			this.id=id;
		}
	public void setName(String name) 
		{
			this.name=name;
		}
	public void setState(String state)
		{
			this.state=state;
		}
	public void setSalesAmount(int salesAmount) 
		{
			this.salesAmount=salesAmount;
		}

	public int getId()
		{
			return this.id;
		}
	public String getName()
	{
		return this.name;
	}
	public String getState()
	{
		return this.state;
	}
	public int getExperience()
	{
		return this.experience;
	}
	public int getSalesAmount()
	{
		return this.salesAmount;
	}	
	

	@Override
	public String toString() {
		return "Sales [Id=" + id  + ", Name=" + name + ", State=" + state + ", Total Experience=" + experience + "Sales Amount="+salesAmount +"]"  ;
	}
	
}
