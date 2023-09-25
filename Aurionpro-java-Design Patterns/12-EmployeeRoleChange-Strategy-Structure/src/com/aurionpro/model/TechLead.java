package com.aurionpro.model;

public class TechLead implements IRole{

	@Override
	public String description() {
		return "Tech Lead:- Description";
	}

	@Override
	public String responsibility() {
		return "Tech Lead:- Assigns code";
	}

}