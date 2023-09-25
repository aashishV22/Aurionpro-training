package com.aurionpro.model;

public class Boy implements IMannerable,IEmotionable{
	public void laugh() {
		System.out.println("Boy is laughing");
	}
	public void cry() {
		System.out.println("Boy is crying");
	}
	public void wish() {
		System.out.println("Boy is praying");
	}
	public void depart() {
		System.out.println("Boy is departing");
	}
}
