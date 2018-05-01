/*	WriteSequenceTest.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 04
 */


import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;



public class WriteSequenceTest {
	/*  This JUnit class tests the method writeSequence().
	 *  Note that writeSequence() has no return value; its only output is to the console.
	 *  As such, two class-level variables, an @Before method, and an @After method are
	 *  used to temporarily redirect writeSequence()'s output from the console to
	 *  a different output stream that can then be accessed by the @Test() methods. 
     */
	
	private 	  PrintStream 			standardOutput;
	private final ByteArrayOutputStream alternateOutput = new ByteArrayOutputStream(); 
	
	private final String CR_LF = "\r\n";  //  carriage return + line feed
	
	
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
		WriteSequence.writeSequence(0);  
	}
	
	@Test
	public void specificTest_1() {
		WriteSequence.writeSequence(1);
		assertEquals(alternateOutput.toString(), "1 " + CR_LF);
	}
	
	@Test
	public void specificTest_2() {
		WriteSequence.writeSequence(2);
		assertEquals(alternateOutput.toString(), "1 1 " + CR_LF);
	}

	@Test
	public void specificTest_3() {
		WriteSequence.writeSequence(3);
		assertEquals(alternateOutput.toString(), "2 1 2 " + CR_LF);
	}
	
	@Test
	public void specificTest_4() {
		WriteSequence.writeSequence(4);
		assertEquals(alternateOutput.toString(), "2 1 1 2 " + CR_LF);
	}
	
	@Test
	public void specificTest_9() {
		WriteSequence.writeSequence(9);
		assertEquals(alternateOutput.toString(), "5 4 3 2 1 2 3 4 5 " + CR_LF);
	}
	
	@Test
	public void specificTest_10() {
		WriteSequence.writeSequence(10);
		assertEquals(alternateOutput.toString(), "5 4 3 2 1 1 2 3 4 5 " + CR_LF);
	}

	
	@Test
	public void generalTest_100() {
		WriteSequence.writeSequence(100);
		assertEquals(alternateOutput.toString(), iterativeAlternative(100));
	}
	
	@Test
	public void generalTest_101() {
		WriteSequence.writeSequence(101);
		assertEquals(alternateOutput.toString(), iterativeAlternative(101));
	}
	
	
	private String iterativeAlternative(int n) {
		//  So that one can test writeSequence() on larger numbers without
		//  having to type long string literals, this method returns the same
		//  string that writeSequence() is intended to print to the console,
		//  only it uses a different algorithm -- for whatever it's worth . . .
		int start = (int) Math.round(n / 2.0);
		String sequence = "";

		for (int i = start; 0 < i; i--) {
			sequence  +=  i + " ";
		}
		if (n % 2  ==  0) {
			sequence += "1 ";
		}
		for (int i = 2; i <= start; i++) {
			sequence  +=  i + " ";
		}
		
		return sequence + CR_LF;
	}
	
}
