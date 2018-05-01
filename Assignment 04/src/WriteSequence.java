/*	WriteSequence.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 04
 */


public class WriteSequence {

	public static void main(String[] args) {
//		writeSequence(-1);
//		writeSequence( 0);

		//  The following sequence will produce the output shown in the textbook.
		writeSequence( 1);
		writeSequence( 2);
		writeSequence( 3);
		writeSequence( 4);
		writeSequence( 5);
		writeSequence( 6);
		writeSequence( 7);
		writeSequence( 8);
		writeSequence( 9);
		writeSequence(10);
	}

	
	public static void writeSequence(int n) {
		/*  Print to the console a symmetrical sequence of n numbers
		 *  composed of descending integers that ends in 1, followed by
		 *  a sequence of ascending integers that begins with 1.
		 *  When n is odd, the sequence has a single 1 in the middle,
		 *  whereas for even values it has two 1s in the middle. 
		 */
		if (n < 1) {
			throw new IllegalArgumentException("Argument must be 1 or greater: " + n);
		}  //  Note that in the recursive helper method, an error won't be thrown when n < 1.
		writeLine(n);
		System.out.println();  //  The ability to include this line without having it get repeated in recursive calls is  
							   //  the main reason for creating the helper method below to handle all of the recursion.
							   //  I'm using this so that a succession of calls such as those seen in main() won't need
							   //  to be interspersed with any empty println() calls to keep their output separated.
	}
	
	private static void writeLine(int n) {  //  Recursive helper method for writeSequence.
		if (n == 0) {  //  Even number base case.  (Print nothing.)
		} else if (n == 1) {  //  Odd number base case.
			writePortion(n);  //  Print one number.
		} else {  //  Recursive case.
			writePortion(n);  //  Print one number on the wind-up.
			writeLine(n - 2);  //  Recursive call.
			writePortion(n);  //  Print the same number on the unwind.
		}
	}

	private static void writePortion(int n) {
		System.out.printf("%d ", Math.round(n / 2.0));  //  Note that this rounds up to the nearest integer.
	}
}
