package com.aurionpro.model;
import com.aurionpro.model.*;
import java.util.*;
public class ClassifyPlayers {
	
	public static List<Players> aListers=new ArrayList<>();
	public static void getAlisters(List<Players> players) 
	{	
		for(int i=0;i<((List<Players>) players).size();i++) 
		{
			if(players.get(i).getMatches()>100 &&((players.get(i).getRuns()>5000) || (players.get(i).getWickets()>150))) 
			{
				aListers.add(players.get(i));
			}
		}
		System.out.println("AListers:");
		System.out.println(aListers);
	}

//----------------------------Blisters---------------------------------//
	public static List<Players> bListers=new ArrayList<>();
	public static void getBlisters(List<Players> players) 
	{	
		for(Players playerB:players) 
		{
			if((playerB.getMatches()>50 && playerB.getMatches()<100) &&((playerB.getRuns()>3000 && playerB.getRuns()<5000) || (playerB.getWickets()>75 && playerB.getWickets()<150))) 
			{
				bListers.add(playerB);
			}
		}
		System.out.println("B-Listers:");
		System.out.println(bListers);
	}

	//----------------------------C listers---------------------------------//
	
	public static List<Players> cListers=new ArrayList<>();
	public static void getClisters(List<Players> players) 
	{	
		for(int i=0;i<((List<Players>) players).size();i++) 
		{
			if(players.get(i).getMatches()<50 &&((players.get(i).getRuns()<3000) || (players.get(i).getWickets()<75))) 
			{
				cListers.add(players.get(i));
			}
		}
		System.out.println("C-Listers:");
		System.out.println(cListers);
	}




}
