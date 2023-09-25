package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultAnalyzerTest {

	@Test
	void test() {
//		fail("Not yet implemented");
	}
	ResultAnalyzer result;
	Board board;
	Cell[] cells;
	@BeforeEach
	void init() 	{		board=new Board();
							cells=board.getBoard();	
							result=new ResultAnalyzer(board);}
	
	@Test
	void horizontalWinCheck_firstRowWin() 
	{
		assertEquals(ResultType.WINNER,result.horizontalWinCheck_firstRowCheck());
	}
	@Test
	void horizontalWinCheck_secondRowWin() throws CellAlreadyMarkedException, InvalidLocationException 
	{
		board.setCellMark(3, MarkType.O);
		board.setCellMark(4, MarkType.O);
		board.setCellMark(5, MarkType.O);
		assertEquals(ResultType.WINNER,result.horizontalWinCheck_secondRowCheck());
	}@Test
	void horizontalWinCheck_thirdRowWin() throws CellAlreadyMarkedException, InvalidLocationException 
	{
		board.setCellMark(6, MarkType.O);
		board.setCellMark(7, MarkType.O);
		board.setCellMark(8, MarkType.O);
		assertEquals(ResultType.WINNER,result.horizontalWinCheck_thirdRowCheck());
	}
		
	@Test
	void verticalWinCheck_firstColumn() throws CellAlreadyMarkedException, InvalidLocationException {
		board.setCellMark(0, MarkType.X);
		board.setCellMark(3, MarkType.X);
		board.setCellMark(6, MarkType.X);
		assertEquals(ResultType.WINNER,result.verticalWinCheck_firstColumn());
	}
	
	
}
