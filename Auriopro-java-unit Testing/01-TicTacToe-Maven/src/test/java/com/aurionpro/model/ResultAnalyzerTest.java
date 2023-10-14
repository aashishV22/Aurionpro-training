package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultAnalyzerTest {

	@Test
	void test() {
//		fail("Not yet implemented");
	}

	ResultAnalyzer analyzer;
	Board board;
	Cell[] cells;

	@BeforeEach
	void init() {
		board = new Board();
		cells = board.getBoard();
		analyzer = new ResultAnalyzer(board);
	}

	@Test
	void horizontalWinCheck_firstRowWin() throws CellAlreadyMarkedException, InvalidLocationException {
		board.setCellMark(0, MarkType.O);
		board.setCellMark(1, MarkType.O);
		board.setCellMark(2, MarkType.O);
		assertEquals(ResultType.WINNER, analyzer.analyzeResult());
	}

	@Test
	void horizontalWinCheck_secondRowWin() throws CellAlreadyMarkedException, InvalidLocationException {
		board.setCellMark(3, MarkType.O);
		board.setCellMark(4, MarkType.O);
		board.setCellMark(5, MarkType.O);
		assertEquals(ResultType.WINNER, analyzer.analyzeResult());
	}

	@Test
	void horizontalWinCheck_thirdRowWin() throws CellAlreadyMarkedException, InvalidLocationException {
		board.setCellMark(6, MarkType.O);
		board.setCellMark(7, MarkType.O);
		board.setCellMark(8, MarkType.O);
		assertEquals(ResultType.WINNER, analyzer.analyzeResult());
	}

	@Test
	void verticalWinCheck_firstColumn() throws CellAlreadyMarkedException, InvalidLocationException {
		board.setCellMark(0, MarkType.X);
		board.setCellMark(3, MarkType.X);
		board.setCellMark(6, MarkType.X);
		assertEquals(ResultType.WINNER, analyzer.analyzeResult());
	}

	@Test
	void verticalWinCheck_secondColumn() throws CellAlreadyMarkedException, InvalidLocationException {
		board.setCellMark(1, MarkType.X);
		board.setCellMark(4, MarkType.X);
		board.setCellMark(7, MarkType.X);
		assertEquals(ResultType.WINNER, analyzer.analyzeResult());
	}

	@Test
	void verticalWinCheck_thirdColumn() throws CellAlreadyMarkedException, InvalidLocationException {
		board.setCellMark(2, MarkType.X);
		board.setCellMark(5, MarkType.X);
		board.setCellMark(8, MarkType.X);
		assertEquals(ResultType.WINNER, analyzer.analyzeResult());
	}

	@Test
	void testDraw() throws CellAlreadyMarkedException {
		cells[0].setMark(MarkType.X);
		cells[1].setMark(MarkType.O);
		cells[2].setMark(MarkType.X);

		cells[3].setMark(MarkType.X);
		cells[4].setMark(MarkType.X);
		cells[5].setMark(MarkType.O);

		cells[6].setMark(MarkType.O);
		cells[7].setMark(MarkType.X);
		cells[8].setMark(MarkType.O);
		assertEquals(ResultType.DRAW, analyzer.analyzeResult());
	}
}
