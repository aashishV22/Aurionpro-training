package com.auriopro.model;

public class Ostrich implements IBird,INonFlyable{

	@Override
	public void walk() {
		System.out.println("Ostrich walking");
	}

	@Override
	public void BodyColor() {
		System.out.println("Grey");
	}
	
	
}
