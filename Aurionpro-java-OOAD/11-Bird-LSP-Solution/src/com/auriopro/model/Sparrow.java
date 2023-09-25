package com.auriopro.model;

public class Sparrow implements IBird,IFlyable{

	@Override
	public void BodyColor() {
		System.out.println("brown");
	}

	@Override
	public void fly() {
		System.out.println("Sparrow can fly");
	}
	
}
