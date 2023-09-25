package com.aurionpro.model;

public class DiwaliInterest implements IFestivalInterest{

	@Override
	public double getInterestRate() {
		return 8.5;
	}

	@Override
	public String getName() {
		return "Diwali";
	}

	@Override
	public String toString() {
		return getName()+" [InterestRate=" + getInterestRate() +"]";
	}

}
