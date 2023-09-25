package com.auriopro.model;

public class Pigeon implements IBird,IFlyable{

	@Override
	public void BodyColor() {
		System.out.println("Light Bule");
	}

	@Override
	public void fly() {
		System.out.println("Pigeon can fly");
	}
	
}
