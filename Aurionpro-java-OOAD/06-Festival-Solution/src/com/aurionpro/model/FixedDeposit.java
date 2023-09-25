package com.aurionpro.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FixedDeposit 
{
	private int    accountNumber;
	private String name;
	private double principal;
	private int    duration;
	private IFestivalInterest festivalInterest;
	private double simpleInterest;

	public FixedDeposit(int accountNumber, String name, double principal, int duration, IFestivalInterest festival) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festivalInterest = festival;
		this.simpleInterest=simpleInterest;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public IFestivalInterest getFestival() {
		return festivalInterest;
	}
	public void setFestival(IFestivalInterest festival) {
		this.festivalInterest = festival;
	}
	
	public double getSimpleInterest() {
		return simpleInterest;
	}
	public void setSimpleInterest(double simpleInterest) {
		this.simpleInterest = simpleInterest;
	}
	public double roundOff(double value) {
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(3, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public void calculateSimpleInterest() {
		this.setSimpleInterest(roundOff((principal*duration*festivalInterest.getInterestRate())/100));
		System.out.println("Simple Interest:-"+roundOff(this.getSimpleInterest()));
	}
	@Override
	public String toString() {
		return "FixedDeposit [accountNumber=" + accountNumber + ", name=" + name + ", principal=" + principal
				+ ", duration=" + duration + ", festival=" + festivalInterest + ", simpleInterest="
				+ simpleInterest + "]";
	}
	
}
