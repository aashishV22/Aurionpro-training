package com.aurionpro.model;

import java.util.Arrays;

public class ResultAnalyzer 
{
	private Board board;
	private ResultType result;
	private Cell[] cells;
	public ResultAnalyzer(Board board) {
		this.board=board;
		this.result=result;
		
	}
	
	public ResultType horizontalWinCheck() {
		this.cells = this.board.getCells();
		for(int i=0;i<3;i++) 
		{
			System.out.println("heklp");
			if(this.cells[i*3].getMark()==this.cells[(i*3)+1].getMark() && this.cells[(i*3)+1].getMark()==this.cells[(i*3)+2].getMark()  )
					{
						System.out.println("Inside if");
						this.result=ResultType.WINNER;
						System.out.println(this.result);
						
					}
			
		}
		return this.result;
	}
	
	


	public ResultType verticalWinCheck() {
		for(int i=0;i<3;i++) 
		{
			if(this.board.getCells()[i]==this.board.getCells()[i+3] && this.board.getCells()[i+3]==this.board.getCells()[i+6]  )
					{
						this.setResult(ResultType.WINNER );
					}
		}
		return this.result;
	}

	
	
	
	
	
	
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ResultType getResult() {
		return result;
	}

	public void setResult(ResultType result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResultAnalyzer [board=" + board + ", result=" + result + "]";
	}
	
	
}
