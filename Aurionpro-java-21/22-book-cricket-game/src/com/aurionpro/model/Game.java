package com.aurionpro.model;
import java.util.Random;   
import com.aurionpro.model.Run;

public class Game 
{
	Random random = new Random(); 
	private int turn;
	private int pageNumber;
	private int totalScore=0;
	
	private int score=0;
	private Run start;
	
	public void setScore(int pageNumber) 
		{
			this.score=pageNumber%7;
		}
	
	public int getScore() 
		{
			return score;
		}
	
	public Run getStart() 
		{
			return start;
		}
	public void setStart(Run start) {
		this.start = start;
	}
	public Random getRandom() {
		return random;
	}
	public void setRandom(Random random) {
		this.random = random;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return " [Turns=" + turn + ", totalScore=" + totalScore+"]";
	}

	
	
	
}
