package com.aurionpro.model;

public class Game {
	private Player currentPlayer;
	private Player[] players;
	private ResultAnalyzer analyser;
	private Board board;
	private static int playerNumber;
	private boolean isGameEnded=false;
	
	public Game(Player player1,Player player2) {
		super();
		this.currentPlayer = player1;
		player1.setMark(MarkType.X);
		player2.setMark(MarkType.O);
		this.players = new Player[]{player1,player2};
		this.board=new Board();
		this.analyser = new ResultAnalyzer(board);
		this.playerNumber=0;
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public ResultAnalyzer getAnalyser() {
		return analyser;
	}
	public void setAnalyser(ResultAnalyzer analyser) {
		this.analyser = analyser;
	}
	
	private void switchPlayer() {
		if(this.playerNumber%2==0) 
		{
			this.currentPlayer=players[1];
			this.playerNumber++;
		}else 
		{	this.currentPlayer=players[0];
			this.playerNumber++;		
		}
	}
	
	
	
	public boolean isGameEnded() {
		return isGameEnded;
	}
	public void setGameEnded(boolean isGameEnded) {
		this.isGameEnded = isGameEnded;
	}
	public void play(int loc)
	{	
	   if(!(analyser.analyzeResult()==ResultType.WINNER)) {
		   try {
			board.setCellMark(loc, currentPlayer.getMark());
			 switchPlayer();
		} catch (CellAlreadyMarkedException | InvalidLocationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getSimpleName());
		}
		  
		   analyser.displayBoard(board);
	   }
	
	}
	
	
}
