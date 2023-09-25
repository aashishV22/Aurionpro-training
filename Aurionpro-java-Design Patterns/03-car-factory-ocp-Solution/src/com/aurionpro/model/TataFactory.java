package com.aurionpro.model;

public class TataFactory implements ICarFactory{
	private static ICarFactory tata;
	private TataFactory() {}
	
	public static ICarFactory getFactory() {
		if(tata==null) {
			tata=new TataFactory();
			
		}
		return tata;
	}
	
	public void printGreetings() {
		System.out.println(this.hashCode()+":-Welcome");
	}
	
	@Override
	public ICars makeCars() {
		return new Tata();
	}

}
