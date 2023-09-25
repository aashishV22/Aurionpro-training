package com.aurionpro.model;

public class FixedDeposit 
{
	private int    accountNumber;
	private String name;
	private double principal;
	private int    duration;
	private FestivalType festival;
	private double rate;
	private double simpleInterest;

	public FixedDeposit(int accountNumber, String name, double principal, int duration, FestivalType festival) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festival = festival;
		this.rate=getInterestRate(festival);
		this.simpleInterest=simpleInterest;
	}
	private double getInterestRate(FestivalType festival2) {
		if(festival.equals(festival2.HOLI)) 
		{
			rate=7.5;
		}else if(festival.equals(festival2.NEWYEAR)) 
		{
			rate=8;
		}else if(festival.equals(festival2.DIWALI)) 
		{
			rate=8.5;
		}else if(festival.equals(festival2.OTHER)) 
		{
			return rate=6.5;
		}
		
		return rate;
		
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
	public FestivalType getFestival() {
		return festival;
	}
	public void setFestival(FestivalType festival) {
		this.festival = festival;
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getSimpleInterest() {
		return simpleInterest;
	}
	public void setSimpleInterest(double simpleInterest) {
		this.simpleInterest = simpleInterest;
	}
	public double calculateSimpleInterest() {
		System.out.println("inside");
		System.out.println(principal);
		System.out.println(duration);
		this.setSimpleInterest((principal*duration*rate)/100);
		return this.getSimpleInterest();
	}
	@Override
	public String toString() {
		return "FixedDeposit [accountNumber=" + accountNumber + ", name=" + name + ", principal=" + principal
				+ ", duration=" + duration + ", festival=" + festival + ", rate=" + rate + ", simpleInterest="
				+ simpleInterest + "]";
	}
	
}
