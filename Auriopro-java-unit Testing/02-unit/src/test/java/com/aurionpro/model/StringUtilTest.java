package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilTest {

	@Test
	void firstAndLasttest() {
		StringUtil util=new StringUtil();
		boolean answer=(util.areFirstAndLastTwoCharactersTheSame("aashishaa"));
		System.out.println(answer);
//		assertEquals(true,answer);
		assertTrue(answer);
	}
	
	@Test
	void truncateTest() {
		StringUtil util=new StringUtil();
		String answer=util.truncateAInFirst2Positions("AAshish");
		assertEquals("shish",answer);
	}

}
