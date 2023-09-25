package com.aurionpro.model;

public class Feet {
	private int feet;
	private int inches;
	
	
	
	
	public Feet(int feet, int inches) {
		super();
		this.feet = feet;
		this.inches = inches;
	}




	public int getFeet() {
		return feet;
	}




	public void setFeet(int feet) {
		this.feet = feet;
	}




	public int getInches() {
		return inches;
	}




	public void setInches(int inches) {
		this.inches = inches;
	}

	public Feet additionFeet(Feet feet2) 
	{	int inches=0;
		Feet addition=new Feet(0,0);
		addition.setInches(this.getInches()+feet2.getInches());
		if(addition.getInches()>=18) 
		{	
			inches+=1;
			addition.setInches(addition.getInches()%12);
		}
		addition.setFeet(this.getFeet()+feet2.getFeet()+inches);
		return addition;
	}


	@Override
	public String toString() {
		return "Addition and conversion [feet=" + feet + ", inches=" + inches + "]";
	}

	
	
}
