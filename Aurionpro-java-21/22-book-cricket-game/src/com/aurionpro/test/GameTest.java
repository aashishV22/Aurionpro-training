package com.aurionpro.test;
import java.util.Random;


import com.aurionpro.model.Game;
import com.aurionpro.model.Run;

import java.util.Scanner;
public class GameTest 
{
	public static void main(String[] args) 
	{
		Game[] player1= 
			{
				new Game(),
				new Game(),
			};
		System.out.println(bookCricket(player1));
		
		
	}
	private static Game bookCricket(Game[] player)
	{
		Game score=new Game();
		int start;
		Random random = new Random();   
		for(int i=0;i<2;i++) 
		{
			if(i==0) 
				{
					System.out.println("\\n--Player 1 - It's your turn-- \n");
					for(int j=1;j!=0;j++) 
					{
					Scanner input=new Scanner(System.in);
					System.out.println("***Turn*** "+j);
					System.out.print("Enter START to open the book: ");
					String start1=input.nextLine();
					try {
						player[i].setStart(Run.valueOf(start1.toUpperCase()));
					}
					catch(Exception e) 
					{
						player[i].setStart(Run.START);
					}
					
					int pageNumber=random.nextInt(301);	
					player[i].setPageNumber(pageNumber);
					System.out.println("Page number is "+player[i].getPageNumber());
					player[i].setScore(pageNumber);
					System.out.println("Score is "+player[i].getScore());
					score.setTurn(j);
					player[i].setTurn(j);
					score.setPageNumber(pageNumber);
					score.setTotalScore(player[i].getTotalScore());
					player[i].setTotalScore(player[i].getTotalScore()+player[i].getScore());
					System.out.println("Total Score is "+player[i].getTotalScore());

					if(player[i].getScore()==0) 
						{
							break;
						}			
					}					
				}
			else
				{
					System.out.println("\n--Player 2" + "-- It's your turn \n");
					for(int j=1;j!=0;j++) 
					{
					Scanner input=new Scanner(System.in);
					System.out.println("***Turn*** "+j);
					System.out.print("Enter START to open the book: ");
					String start1=input.nextLine();
					try {
						player[i].setStart(Run.valueOf(start1.toUpperCase()));
					}
					catch(Exception e) 
					{
						player[i].setStart(Run.START);
					}
					
					int pageNumber=random.nextInt(301);	
					player[i].setPageNumber(pageNumber);
					System.out.println("Page number is "+player[i].getPageNumber());
					player[i].setScore(pageNumber);
					System.out.println("Score is "+player[i].getScore());
					player[i].setTurn(j);
					score.setTurn(j);
					score.setPageNumber(pageNumber);
					score.setTotalScore(player[i].getTotalScore());
					player[i].setTotalScore(player[i].getTotalScore()+player[i].getScore());
					System.out.println("Total Score is "+player[i].getTotalScore());
					int x=i-1;
					if(player[i].getScore()==0) 
						{
						score.setTotalScore(player[i].getTotalScore());
						System.out.println("OOPS!! You scored ZERO \n You are OUT!!!  \nPlayer 1 WINS!!!" );
						System.out.println("Player 1 Score="+player[0]);
						break;
						}
						
						
					if (player[i].getTotalScore()>=player[x].getTotalScore()) 
						{	
							score.setTotalScore(player[i].getTotalScore());
							System.out.println("You beat the player 1 score \n");
							System.out.println("Player 1 Score="+player[0]);
							break;
						}
					}
					System.out.print("Player 2 Score=");
					return player[i];
				}
		
		}
		System.out.print("Player 1 Score=");
		return player[0];
		
	}
}
