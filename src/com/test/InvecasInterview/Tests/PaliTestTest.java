package com.test.InvecasInterview.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.InvecasInterview.PaliTest;

public class PaliTestTest {
	PaliTest pt = null;
	@Before
	public void setUp() throws Exception {
		pt = new PaliTest();
	}

	@After
	public void tearDown() throws Exception {
		pt = null;
	}

	@Test
	public void testEmptyString() {	
		assertTrue (pt.testString(""));
	}
	@Test
	public void testSingleStringsTrue() {	
		assertTrue (pt.testString("BoB"));
		assertTrue (pt.testString("Bob"));
		assertTrue (pt.testString(""));
		assertTrue (pt.testString("s"));
	}
	@Test
	public void testSingleStringsFalse() {	
		assertFalse(pt.testString("Bog"));
		assertFalse(pt.testString("gob"));
		assertFalse(pt.testString("gobboz"));
		assertFalse(pt.testString("g0bbog"));
	}
	@Test
	public void testMultiStrings() {	
		assertTrue (pt.testString("A nut for a jar of tuna"));
		assertTrue (pt.testString("A nut for a jar of tuna\n"));
		assertTrue (pt.testString("B\nA nut for a jar of tuna\nB"));
	}
	@Test
	public void testMultiStringsFalse() {	
		assertFalse(pt.testString("A nut for a k jar of tuna"));
		assertFalse(pt.testString("A nut x for a jar of tuna\n"));
		assertFalse(pt.testString("B\nA nut for a jar of k tuna\nB"));
	}
	@Test
	public void testStringsWithNonNumbericaChars() {	
		assertTrue (pt.testString("A = nut * for # a $ jar & of ! tuna"));
	}
	@Test
	public void testStringsWithOnlyNonNumbericaChars() {	
		assertTrue (pt.testString("*#$&!"));
	}
	@Test
	public void testStringsWithOnlySpaces() {	
		assertTrue (pt.testString(" "));
		assertTrue (pt.testString("       "));
	}
	public void testNullString() {	
		assertTrue (pt.testString(null));
	}
}
