package com.aurionpro.model;

public class Maruti implements ICars
{

	@Override
	public void start() {
		System.out.println("Maruti car Started");
	}

	@Override
	public void stop() {
		System.out.println("Maruti car stopped");
	}
	
	
}
