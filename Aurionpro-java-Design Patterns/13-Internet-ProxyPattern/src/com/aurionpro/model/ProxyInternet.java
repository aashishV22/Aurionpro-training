package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements IInternet{

	private RealInternet internet;
	private List<String> bannedSites;
	public ProxyInternet() {
		super();
		this.internet = new RealInternet();
		this.bannedSites=new ArrayList<String>();
		this.bannedSites.add("Aashish");
		this.bannedSites.add("Nitesh");
	}

	@Override
	public void connectTo(String server) {
		if(!this.bannedSites.contains(server)) {
			internet.connectTo(server);
		}
		else {
			System.out.println("It's a banned link");
		}
	}
}
