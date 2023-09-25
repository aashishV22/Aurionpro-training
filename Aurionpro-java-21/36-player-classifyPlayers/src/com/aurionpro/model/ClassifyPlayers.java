package com.aurionpro.model;
import com.aurionpro.model.*;
public class ClassifyPlayers {
	
	
	public static Players[] getAlisters(Players[] players) 
	{	
		int count=0;
		for(int i=0;i<players.length;i++) 
		{
			if(players[i].getMatches()>100 &&((players[i].getRuns()>5000) || (players[i].getWickets()<150))) 
			{
				count++;
				//System.out.println(players[i]);
			}
		}
		Players[] aList=new Players[count];
		for(int i=0,j=0;i<players.length;i++) 
		{
			if(players[i].getMatches()>100 &&((players[i].getRuns()>5000) || (players[i].getWickets()<150))) 
			{	
				aList[j++]=players[i];
			}
		}	
		return aList;
	}
	
	
	
}
