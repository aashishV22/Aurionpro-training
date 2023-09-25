package com.aurionpro.model;

public class Robot implements IWorker{
	@Override
	public void startWork() {
		System.out.println("Work Started by Robot");
	}
	@Override
	public void stopWork() {
		System.out.println("Word Stopped by Robot");
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drink() {
		System.out.println("Robot can't drink ");
	}
}
