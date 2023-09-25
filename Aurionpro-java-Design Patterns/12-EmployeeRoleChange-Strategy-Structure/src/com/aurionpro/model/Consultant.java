package com.aurionpro.model;

public class Consultant implements IRole{

	@Override
	public String description() {
		return "Consultant:- Description";
	}

	@Override
	public String responsibility() {
		return "Consultant:- Writes code";
	}

}
