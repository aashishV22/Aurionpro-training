package com.aurionpro.model;

public class Robot implements IWorkable{
	@Override
	public void startWork() {
		System.out.println("Work Started by Robot");
	}
	@Override
	public void stopWork() {
		System.out.println("Word Stopped by Robot");
	}
}
