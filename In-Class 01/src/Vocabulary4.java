/*	Vocabulary4.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  In-Class Coding Project 01
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;


public class Vocabulary4 {

	
	public static void main(String[] args) throws FileNotFoundException {
		//  Request the names of two text files from the user.
		//  Generate a HashSet to hold one copy of each word.
		//  Report the number of unique words from each file; the number of words that the
		//   two files have in common; and, for each file, the proportion of those common words to
		//   the total number of unique words. 
		
		System.out.println("This program compares the vocabulary of two\r\n" + 
				"text files, reporting the number of words\r\n" + 
				"in common and the percent of overlap.\r\n");

		Scanner console = new Scanner(System.in);
		HashSet<String> wordSet1 = getSet(console, 1); 
		HashSet<String> wordSet2 = getSet(console, 2); 
		HashSet<String> intersection = new HashSet<String>(wordSet1);  //  This is a clone of wordSet1. 
		intersection.retainAll(wordSet2);  //  This is the intersection of WordSet1 and WordSet2.

		int wordCount1 		  = wordSet1.size();
		int wordCount2 		  = wordSet2.size();
		int intersectionCount = intersection.size();
		
		System.out.println();
		System.out.println("File #1 words = " + wordCount1);
		System.out.println("File #2 words = " + wordCount2);
		System.out.println("Common words  = " + intersectionCount);
		System.out.println("% of File 1 in overlap = " + 100.0 * intersectionCount / wordCount1);
		System.out.println("% of File 2 in overlap = " + 100.0 * intersectionCount / wordCount2);
		
		console.close();
	}
	

	private static HashSet<String> getSet(Scanner console, int fileNumber) throws FileNotFoundException {
		//  Request the name of a file in the same directory as this program.
		//  Read each word from that file into a HashSet (which automatically eliminates duplicates).
		//  Return the HashSet.
		
		System.out.print("File #" + fileNumber + " name?  ");
		Scanner file = new Scanner(new File(console.nextLine()));

		HashSet<String> wordSet = new HashSet<String>();
		while (file.hasNext()) {
			wordSet.add(file.next().toLowerCase());
		}
		file.close();
		
		return wordSet;
	}
}
