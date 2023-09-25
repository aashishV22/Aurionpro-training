package com.aurionpro.test;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.ClassifyPlayers;
import com.aurionpro.model.Players;
public class PlayerTest 
{
public static void main(String[] args) 
	{
		List<Players> players=new ArrayList<>();
				players.add(new Players(1,"Aashish",231,432,170));
				players.add(new Players(2,"Vedang",55,3432,10));
				players.add(new Players(3,"Tanish",201,23432,200));
				players.add(new Players(4,"Siddhant",21,332,10));
				players.add(new Players(5,"Suswar",431,243323432,300));
				players.add(new Players(6,"Aniket",40,32,20));
		ClassifyPlayers obj=new ClassifyPlayers();
		System.out.print(obj.getAlisters(players));
		obj.getBlisters(players);
		obj.getClisters(players);
	}
}
