package com.aurionpro.test;
import java.util.Scanner;
public class GameTest 
{
	public static void main(String[] args) 
	{	
		Scanner input=new Scanner(System.in);
		String[][] board= {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
		System.out.println(board.length);
		for(int i=0;i<board.length;i++)
		{	
			for(int j=0;j<board.length;j++)
			{
			System.out.print("|"+board[i][j]);
			}
			System.out.print("| \n");
		}
		System.out.print("Player  enter player 1 name: ");
		String player1=input.nextLine();
		System.out.print("\nPlayer  enter player 2 name: ");
		String player2=input.nextLine();
		boolean isplayer1 = true;
		boolean isGameEnded=false;
		while(!isGameEnded) 
		{
			drawBoard(board);
			if(isplayer1) 
				{
					System.out.println(player1 + "'s Turn (X):");
				}
			else 
				{
				System.out.println(player2 + "'s Turn (O):");
				}
			String entryInput="-";
			if(isplayer1) 
				{
					entryInput="X";
				}
			else 
				{
					entryInput="O";
				}

			int row = 0;
			int col = 0;

			while(true) 
			{
				System.out.print("Enter a row number (0, 1, or 2): ");
				row = input.nextInt();
				System.out.print("Enter a column number (0, 1, or 2): ");
				col = input.nextInt();
				if(row < 0 || col < 0 || row > 2 || col > 2) 
					{
						System.out.println("This position is off the bounds of the board! Try again.");
					} 
				else if(board[row][col] != "-") 
					{
						System.out.println("Someone has already made a move at this position! Try again.");
					}
				else 
					{
						break;
					}
			}
			board[row][col] = entryInput;
			if(playerHasWon(board) == "X") {
				System.out.println(player1 + " has won!");
				isGameEnded = true;
			} else if(playerHasWon(board) == "O") {
				System.out.println(player2 + " has won!");
				isGameEnded = true;
			} else {

				if(boardIsFull(board)) {
					System.out.println("It's a tie!");
					isGameEnded = true;
				} else {
					isplayer1 = !isplayer1;
				}

			}
		drawBoard(board);
			
		}
		
		
	}
	public static void drawBoard(String[][] board) 
	{
		System.out.println("Board:");
		for(int i = 0; i < 3; i++) 
		{
			for(int j = 0; j < 3; j++) 
			{
				System.out.print("|"+board[i][j]);
			}
			System.out.print("| \n");
		}
	}
	public static String playerHasWon(String[][] board) 
	{	
		for(int i = 0; i < 3; i++) 
			{
				if(board[i][0] == board[i][1] && board[i][1] == board[i][2]) 
				{
				return board[i][0];
				}
			}

		for(int j = 0; j < 3; j++) 
			{
				if(board[0][j] == board[1][j] && board[1][j] == board[2][j]) 
				{
				return board[0][j];
				}
			}

		if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) 
			{
				return board[0][0];
			}
		if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2]) 
			{
				return board[2][0];
			}
		return " ";
		

	}

	public static boolean boardIsFull(String[][] board) {
		for(int i = 0; i < 3; i++) 
		{
			for(int j = 0; j < 3; j++) 
			{
				if(board[i][j] == "-") 
				{
					return false;
				}
			}
		}
		return true;
	}
}
	
