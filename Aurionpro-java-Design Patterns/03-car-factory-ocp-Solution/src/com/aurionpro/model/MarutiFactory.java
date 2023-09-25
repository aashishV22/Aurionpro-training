package com.aurionpro.model;

public class MarutiFactory implements ICarFactory{
	private static ICarFactory maruti;
	private MarutiFactory() {}
	
	public static ICarFactory getFactory() {
		if(maruti==null) {
			maruti=new MarutiFactory();
			
		}
		return maruti;
	}
	
	public void printGreetings() {
		System.out.println(this.hashCode()+":-Welcome");
	}
	
	@Override
	public ICars makeCars() {
		return new Maruti();
	}
}

