package com.aurionpro.model;

public class Man implements IMannerable{

	@Override
	public void wish() {
		System.out.println("Man is praying");
		
	}

	@Override
	public void depart() {
		System.out.println("Man is departing");
	}

}
