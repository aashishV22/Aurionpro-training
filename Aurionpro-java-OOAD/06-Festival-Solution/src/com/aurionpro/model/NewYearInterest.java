package com.aurionpro.model;

public class NewYearInterest implements IFestivalInterest
{
	@Override
	public double getInterestRate() {
		return 8.0;
	}

	@Override
	public String getName() {
		return "New Year";
	}

	@Override
	public String toString() {
		return getName()+" [InterestRate=" + getInterestRate() +"]";
	}
}
