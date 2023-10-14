package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import com.aurionpro.model.*;

class GameTest {
	@Test
	 void main() throws CellAlreadyMarkedException, InvalidLocationException {
		Player player1=new Player("Aashish");
		Player player2=new Player("Vedant");

		Game game=new Game(player1,player2);
	      
//		game.play(0);
//		game.play(3);
//		game.play(1);
//		game.play(4);
//		game.play(2);
//		game.play(5);
		Scanner sc=new Scanner(System.in);
		
		while(game.getAnalyser().analyzeResult()!=ResultType.WINNER) 
		{
			System.out.println("Player:- "+game.getCurrentPlayer());
			System.out.print("Enter location number from [0 to 8] :- " );
			int loc =sc.nextInt();
			game.play(loc);
			if(game.getAnalyser().analyzeResult()!=ResultType.PROGRESS) {
				System.out.println("Game ended");
				break;
			}
//			System.out.println("Game ended :"+game.isGameEnded());
//			System.out.println(game.getAnalyser().getResult());
		
		}

	
	}
	
	

}
