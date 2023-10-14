package com.aurionpro.model;

public class ResultAnalyzer {
	private Board board;
	private ResultType result;
	private Cell[] cells;
	private boolean isWinned = false;

	public ResultAnalyzer(Board board) {
		this.board = board;
		this.result = ResultType.PROGRESS;
		this.cells = this.board.getBoard();
	}

	public void horizontalWinCheck() {
		for (int i = 0; i < 3; i++) {
			if (this.cells[i * 3].getMark() == this.cells[(i * 3) + 1].getMark()
					&& this.cells[(i * 3) + 1].getMark() == this.cells[(i * 3) + 2].getMark()
					&& this.cells[i * 3].getMark() != MarkType.EMPTY) {
				this.setResult(ResultType.WINNER);
			}
		}
	}

	public void verticalWinCheck() {
		for (int i = 0; i < 3; i++) {
			if (this.cells[i].getMark() == this.cells[i + 3].getMark()
					&& this.cells[i + 3].getMark() == this.cells[i + 6].getMark()
					&& this.cells[i].getMark() != MarkType.EMPTY) {
				this.setResult(ResultType.WINNER);
			}
		}
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

	public static void displayBoard(Board board) {
		Cell[] cells = board.getCells();
		for (int i = 0; i < 3; i++) {
			System.out.println(
					"|" + cells[i * 3].getMark() + "|" + cells[(i * 3) + 1] + "|" + cells[(i * 3) + 2] + "|" + "\n");
		}

	}

	public void diagonalWinCheck() {
		if (this.cells[0].getMark() == this.cells[4].getMark() && this.cells[4].getMark() == this.cells[8].getMark()
				&& this.cells[0].getMark() != MarkType.EMPTY
				|| this.cells[2].getMark() == this.cells[4].getMark()
						&& this.cells[4].getMark() == this.cells[6].getMark()
						&& this.cells[2].getMark() != MarkType.EMPTY && this.cells[4].getMark() != MarkType.EMPTY) {
			this.result = ResultType.WINNER;

		}
	}

	public ResultType analyzeResult() { 
		 diagonalWinCheck(); 
		 horizontalWinCheck(); 
		 verticalWinCheck(); 
		 if (result !=ResultType.WINNER) { 
		  if (!board.isBoardFull()) { 
		   result = ResultType.PROGRESS; 
		  } else if(board.isBoardFull()){ 
		   result = ResultType.DRAW; 
		  } 
		 } 
		 return result; 
		}

}
