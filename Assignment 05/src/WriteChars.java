import java.util.Arrays;

/*	WriteChars.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 05
 */


public class WriteChars {

	public static void main(String[] args) {
		//  Uncomment the following method calls to test for an illegal argument exception.
//		writeChars(-1);
//		writeChars( 0);

		//  The following sequence will produce the output shown in the textbook.
		writeChars( 1);
		writeChars( 2);
		writeChars( 3);
		writeChars( 4);
		writeChars( 5);
		writeChars( 6);
		writeChars( 7);
		writeChars( 8);
	}

	
	public static void writeChars(int n) {
		/*  This method prints out a total of n characters.  The middle character(s)
		 *  should always be one '*' character if n is odd, or two '*' characters
		 *  if n is even.  Before the middle '*' characters, this method will output
		 *  '<' characters.  After the middle '*' characters, this method will output
		 *  '>' characters.  Finally, a newline will be printed at the end.
		 */
		writeChars(n, true);  //  Private helper method to handle recursion.
	}
	
	private static void writeChars(int n, boolean printNewLine) {  //  Recursive helper method for writeChars().
		/*	Parameter:		Description
		 * 
		 *  n:  			The number of characters to be printed to the console.
		 *  printNewLine:	Specifies whether or not a newline character will be
		 *  					printed at the end of the character sequence.
		 *  					This may be true on the original method call,
		 *  					but it must be false on all recursive method calls.
		 */
		
		if (n < 1) {
			throw new IllegalArgumentException("Argument must be 1 or greater: " + n);
		}

		if (n == 1) {  //  Even number base case.
			System.out.print('*');
		} else if (n == 2) {  //  Odd number base case.
			System.out.print("**");
		} else {  //  n > 2.  Recursive case.
			System.out.print('<');  //  Print this character on the recursive wind-up.
			writeChars(n - 2, false);  //  Recursive call.
			System.out.print('>');  //  Print this character on the recursive unwind.
		}
		
		if (printNewLine) {
			System.out.println();
		}
	}
	
}
