package com.aurionpro.model;

public class RealInternet implements IInternet{

	@Override
	public void connectTo(String server) {
		System.out.println("Connected to "+server);
	}

}
