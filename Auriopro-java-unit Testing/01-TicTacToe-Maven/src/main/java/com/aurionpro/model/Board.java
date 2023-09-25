package com.aurionpro.model;

import java.util.Arrays;

public class Board 
{
	Cell[] cells=new Cell[9];
	public Board() {
		this.cells[0]=new Cell(MarkType.X);
		this.cells[1]=new Cell(MarkType.X);
		this.cells[2]=new Cell(MarkType.X);
		this.cells[3]=new Cell();
		this.cells[4]=new Cell();
		this.cells[5]=new Cell();
		this.cells[6]=new Cell();
		this.cells[7]=new Cell();
		this.cells[8]=new Cell();
	}
	
	
	
	public Cell[] getCells() {
		return this.cells;
	}

	public Cell[] getBoard() {
			return this.cells;
	}
	
	public boolean isBoardFull() {
		for(int x=0;x<9;x++) {
			if(cells[x].isEmpty()==false) {
				return true;
			}
		}
		return false;
	}

	public void setCellMark(int loc,MarkType mark) throws CellAlreadyMarkedException, InvalidLocationException 
	{
		if(loc<0 || loc>8) {
			throw new InvalidLocationException("Invalid Location ");

		}
		this.cells[loc].setMark(mark);
	}



	@Override
	public String toString() {
		return "Board [cells=" + Arrays.toString(cells) + "]";
	}


	
}
