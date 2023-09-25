package com.aurionpro.test;

import com.aurionpro.model.*;

public class PolymorphismTest {
	
	public static void main(String[] args) {
	Man man=new Man();
	Boy boy=new Boy();
	atTheParty(boy);
	//atTheParty(man);
	atTheMovie(boy);
	atTheMovie(man);
	}
	
	public static void atTheParty(IEmotionable obj) {
		System.out.println("At the party ");
		obj.cry();
		obj.laugh();
	}
	public static void atTheMovie(IMannerable obj) {
		System.out.println("At the movie");
		obj.wish();
		obj.depart();
	}
}
