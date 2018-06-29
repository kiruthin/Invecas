package com.test.InvecasInterview.Tests;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.test.InvecasInterview.StringCounter;

public class StringCounterTest {

	StringCounter sc = null;
	@Before
	public void setUp() throws Exception {
		sc = new StringCounter();
	}

	@After
	public void tearDown() throws Exception {
		sc = null;
	}
	@Test
	public void CounterTest() throws IOException {
		sc.setFPath(
				"."					+ File.separator 
				+"src"  			+ File.separator 
				+"com" 				+ File.separator 
				+"test"				+ File.separator 
				+"InvecasInterview"	+ File.separator 
				+"Tests"			+ File.separator 
				+"Resources"		+ File.separator 
				+"InputFile1.txt");
		sc.initialize_hash();
		
		assertEquals( "The total for Jen is 19.\n"
					+ "The total for Ken is 19.\n"
					+ "The total for John is 3.\n"
					+ "The total for Jane is 1.\n", sc.print());
	}
	@Test
	public void TestMalformedInputSkipped() {
		try
		{
			sc.setFPath(
				"."					+ File.separator 
				+"src"  			+ File.separator 
				+"com" 				+ File.separator 
				+"test"				+ File.separator 
				+"InvecasInterview"	+ File.separator 
				+"Tests"			+ File.separator 
				+"Resources"		+ File.separator 
				+"InputFile2.txt");
			sc.initialize_hash();
		
			assertEquals( "", sc.print());	
		}
		catch(IOException e)
		{
			fail(this.getClass().getEnclosingMethod() + " failed ");
			e.printStackTrace();
		}
	}
	@Test(expected=IOException.class)
	public void testIOException() throws IOException {
		sc.setFPath(
				"."					+ File.separator 
				+"src"  			+ File.separator 
				+"com" 				+ File.separator 
				+"test"				+ File.separator 
				+"InvecasInterview"	+ File.separator 
				+"Tests"			+ File.separator 
				+"Resources"		+ File.separator 
				+"DummyFile.txt");
		sc.initialize_hash();
	}
}
