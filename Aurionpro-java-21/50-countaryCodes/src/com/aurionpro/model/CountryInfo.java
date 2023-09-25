package com.aurionpro.model;

public class CountryInfo 
{
	private String countryName;
	private  int region;
	public CountryInfo(String countryName, int region) {
		super();
		this.countryName = countryName;
		this.region = region;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	
	
	
	@Override
	public String toString() {
		return "CountryInfo [countryName=" + countryName + ", region=" + region + "]";
	}
	
	
}
