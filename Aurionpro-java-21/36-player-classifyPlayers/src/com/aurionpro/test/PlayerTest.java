package com.aurionpro.test;
import com.aurionpro.model.*;
public class PlayerTest 
{
public static void main(String[] args) 
	{
		Players[] players= 
			{
				new Players(1,"Aashish",231,2323432,100),
				new Players(2,"Vedang",331,233432,110),
				new Players(3,"Tanish",201,23432,200),
				new Players(4,"Siddhant",21,332,10),
				new Players(5,"Suswar",431,243323432,300),
				new Players(6,"Aniket",531,332323432,400),	
			};
		ClassifyPlayers obj=new ClassifyPlayers();
		Players[] aList=obj.getAlisters(players);
		for(int i=0;i<aList.length;i++) {
		System.out.println(aList);
		}
	}
}
