package com.aurionpro.test;
import java.util.*;

import com.aurionpro.model.PigGame;

public class PigGameTest 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Random random = new Random();	
		PigGame p1 = new PigGame();
		int turn=1;
		int max=7;
		int min=1;
		int scoreRolled = (int)(Math.random()*(max-min+1)+min);  
		while(p1.getTotalScore()<=20) 
		{
			p1.setTurnScore(turn);
			System.out.println("Turn "+ turn);
			System.out.print("Roll or Hold:");
			String roll=sc.nextLine();
			p1.setAction(roll);
			if(p1.getAction().equalsIgnoreCase("roll")) 
				{
					p1.setDiceScore(scoreRolled);
					if(p1.getDiceScore()==1) 
					{
						System.out.println("Dice: "+p1.getDiceScore());
						p1.setTotalScore(0);
						p1.setTotalScore(0);
						turn+=1;
						System.out.println("Total score is "+p1.getTotalScore());
					}
					else {
					System.out.println("Dice:"+p1.getDiceScore());
					
					p1.setTotalScore(p1.getTotalScore()+p1.getDiceScore());
					System.out.println("Total Score till now is "+p1.getTotalScore());
					}
				}
			else if(p1.getAction().equalsIgnoreCase("hold")) 
				{
					System.out.println("Total Score is "+p1.getTotalScore());
					turn+=1;
				}
	
		
		}
		if(p1.getTotalScore()>20) 
			{
				System.out.println("You Finished in "+p1.getTurnScore()+"  turns");
				System.out.print("Game Over");
			}
	}
}
