package com.aurionpro.model;

public class Labour implements IWorker
{
	@Override
	public void startWork() {
		System.out.println("Work Started by labour ");
	}
	@Override
	public void stopWork() {
		System.out.println("Work Stopped by labour");
	}
	@Override
	public void eat() {
		System.out.println("Labour is Eating");
	}
	@Override
	public void drink() {
		System.out.println("Labour is Drnking");
	}
}
