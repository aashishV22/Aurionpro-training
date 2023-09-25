package com.aurionpro.model;

public class GuitarSpec 
{
	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private int  numStrings;
	public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood,int numStrings) {
		super();
		this.builder = builder;
		this.model 	   = model;
		this.type 	   = type;
		this.backWood  = backWood;
		this.topWood   = topWood;
		this.numStrings= numStrings;
	}
	
	public int getNumStrings() 
	{
		return numStrings;
	}
	public void setNumStrings(int numStrings) 
	{
		this.numStrings = numStrings;
	}

	public Builder getBuilder() 
	{
		return builder;
	}
	public void setBuilder(Builder builder) 
	{
		this.builder = builder;
	}
	
	public String getModel() 
	{
		return model;
	}
	public void setModel(String model) 
	{
		this.model = model;
	}
	
	public Type getType() 
	{
		return type;
	}
	public void setType(Type type) 
	{
		this.type = type;
	}
	
	public Wood getBackWood() 
	{
		return backWood;
	}
	public void setBackWood(Wood backWood) 
	{
		this.backWood = backWood;
	}
	
	public Wood getTopWood() 
	{
		return topWood;
	}
	public void setTopWood(Wood topWood) 
	{
		this.topWood = topWood;
	}
	
	
	
	public boolean match(GuitarSpec inventorySpecs) 
	{
		if(this.getBuilder()==inventorySpecs.getBuilder() && this.getBackWood()==inventorySpecs.getBackWood() && 
				this.getModel().equalsIgnoreCase(inventorySpecs.getModel()) && this.getNumStrings()==inventorySpecs.getNumStrings()
				&& this.getTopWood()==inventorySpecs.getTopWood() && this.getType()==inventorySpecs.getType()) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "GuitarSpec [builder=" + builder + ", model=" + model + ", type=" + type + ", backWood=" + backWood
				+ ", topWood=" + topWood + ", numStrings=" + numStrings + "]";
	}
	
}
