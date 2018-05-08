/*	WriteCharsTest.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 05
 */


import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class WriteCharsTest {
	/*  This JUnit class tests the method writeChars().
	 *  Note that writeChars() has no return value; its only output is to the console.
	 *  As such, two class-level variables, an @Before method, and an @After method are
	 *  used to temporarily redirect writeChars()'s output from the console to
	 *  a different output stream that can then be accessed by the @Test() methods. 
     */

	private 	  PrintStream 			standardOutput;
	private final ByteArrayOutputStream alternateOutput = new ByteArrayOutputStream(); 
	
	private final String CR_LF = "\r\n";  //  carriage return + line feed
										  //  as produced by a call to System.out.println()
	
	
	@Before
	public void redirectOutput() {
		//  Retain a reference to where output is normally directed. 
		standardOutput = System.out;
		//  Redirect output to a location where it can be seen by a unit test.
		System.setOut(new PrintStream(alternateOutput));
	}

	@After
	public void restoreStandardOutput() {
		//  Restore the normal output location.
		System.setOut(standardOutput);
	}

	

	@Test (expected = IllegalArgumentException.class)
	public void specificTest_0() throws IllegalArgumentException {
	//  Input of less than 1 should cause writeSequence() to throw an IllegalArgumentException.
	//  This test will fail if writeSequence() does not throw an IllegalArgumentException.
		WriteChars.writeChars(0);  
	}
	
	@Test
	public void specificTest_1() {
		WriteChars.writeChars(1);
		assertEquals(alternateOutput.toString(), "*" + CR_LF);
	}
	
	@Test
	public void specificTest_2() {
		WriteChars.writeChars(2);
		assertEquals(alternateOutput.toString(), "**" + CR_LF);
	}

	@Test
	public void specificTest_3() {
		WriteChars.writeChars(3);
		assertEquals(alternateOutput.toString(), "<*>" + CR_LF);
	}
	
	@Test
	public void specificTest_4() {
		WriteChars.writeChars(4);
		assertEquals(alternateOutput.toString(), "<**>" + CR_LF);
	}
	
	@Test
	public void specificTest_7() {
		WriteChars.writeChars(7);
		assertEquals(alternateOutput.toString(), "<<<*>>>" + CR_LF);
	}
	
	@Test
	public void specificTest_8() {
		WriteChars.writeChars(8);
		assertEquals(alternateOutput.toString(), "<<<**>>>" + CR_LF);
	}

	@Test
	public void specificTest_88() {
		WriteChars.writeChars(88);
		assertEquals(alternateOutput.toString(), directAlternative(88));
	}
	
	@Test
	public void specificTest_89() {
		WriteChars.writeChars(89);
		assertEquals(alternateOutput.toString(), directAlternative(89));
	}
	
	
	
	private String directAlternative(int n) {
		//  So that one can test writeChars() on larger numbers without
		//  having to type long string literals, this method returns the same
		//  string that writeChars() is intended to print to the console,
		//  only it uses a different algorithm -- for whatever it's worth . . .
		
		int numberOfEndChars  =  (int) Math.round((n - 2) / 2.0);  //  The number of '<' and '>' characters each to be generated.
		char[] endChars       =  new char[numberOfEndChars];  //  Empty array of length numberOfEndChars

		Arrays.fill(endChars, '<');  //  Fill array with '<' characters
		String beginning =  new String(endChars);

		String middle    =  n % 2 == 0   ?  "**"  :  "*";
		
		Arrays.fill(endChars, '>');  //  Fill array with '>' characters
		String end       =  new String(endChars);

		
		return  beginning + middle + end + CR_LF;
	}
	
}
