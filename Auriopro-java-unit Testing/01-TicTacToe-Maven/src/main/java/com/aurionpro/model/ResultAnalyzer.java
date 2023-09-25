package com.aurionpro.model;

import java.util.Arrays;

public class ResultAnalyzer 
{
	private Board board;
	private ResultType result;
	private Cell[] cells;
	private boolean isWinned=false;
	public ResultAnalyzer(Board board) {
		this.board=board;
		this.result=result;
		
	}
	
	public ResultType horizontalWinCheck() {
		Cell[] cells = this.board.getBoard();
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

	public ResultType horizontalWinCheck_firstRowCheck() {
		this.cells = this.board.getBoard();
			if(this.cells[0].getMark()==this.cells[1].getMark() && this.cells[1].getMark()==this.cells[2].getMark()  )
					{
						System.out.println("Inside if");
						this.result=ResultType.WINNER;
						System.out.println(this.result);
						this.isWinned=true;
					}
		return this.result;
	}
	
	public ResultType horizontalWinCheck_secondRowCheck() {
		this.cells = this.board.getBoard();
			if(this.cells[3].getMark()==this.cells[4].getMark() && this.cells[4].getMark()==this.cells[5].getMark()  )
					{
						System.out.println("Inside if");
						this.result=ResultType.WINNER;
						System.out.println(this.result);
						this.isWinned=true;
					}
		return this.result;
	}
	public ResultType horizontalWinCheck_thirdRowCheck() {
		this.cells = this.board.getBoard();
			if(this.cells[6].getMark()==this.cells[7].getMark() && this.cells[7].getMark()==this.cells[8].getMark()  )
					{
						System.out.println("Inside if");
						this.result=ResultType.WINNER;
						System.out.println(this.result);
						this.isWinned=true;
					}
		return this.result;
	}

	public ResultType verticalWinCheck_firstColumn() {
		this.cells = this.board.getBoard();
		if(this.cells[0].getMark()==this.cells[3].getMark() && this.cells[3].getMark()==this.cells[6].getMark()  )
				{
					System.out.println("Inside if");
					this.result=ResultType.WINNER;
					System.out.println(this.result);
					this.isWinned=true;
				}
	return this.result;
	}
	
	public ResultType verticalWinCheck_secondColumn() {
		this.cells = this.board.getBoard();
		if(this.cells[0].getMark()==this.cells[3].getMark() && this.cells[3].getMark()==this.cells[6].getMark()  )
				{
					System.out.println("Inside if");
					this.result=ResultType.WINNER;
					System.out.println(this.result);
					this.isWinned=true;
				}
	return this.result;
	}
	public ResultType verticalWinCheck_thirdColumn() {
		this.cells = this.board.getBoard();
		if(this.cells[0].getMark()==this.cells[3].getMark() && this.cells[3].getMark()==this.cells[6].getMark()  )
				{
					System.out.println("Inside if");
					this.result=ResultType.WINNER;
					System.out.println(this.result);
					this.isWinned=true;
				}
	return this.result;
	}

}
