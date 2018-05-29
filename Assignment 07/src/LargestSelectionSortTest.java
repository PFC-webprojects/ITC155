/*	LargestSelectionSortTest.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 07
 */


import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;


public class LargestSelectionSortTest {

	public static int[] randomArray(int length) {
	/*	For testing purposes, generate and return an array, of
	 *  length length, consisting of randomly-generated ints. 
	 */
		int[] numbers = new int[length];
		Random randomizer = new Random();
		for (int i = 0; i < length; i++) {
			numbers[i] = randomizer.nextInt();
		}
		
		return numbers;
	}
	
	private static boolean isAscending(int[] test) {
	/*	For testing purposes, return a boolean indicating
	 *  whether or not the given array test is sorted
	 *  in ascending order.
	 */
		for (int i = 0; i < test.length - 1; i++) {
			if (test[i + 1]  <  test[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	@Test
	public void testControlCaseForIsAscending() {
	/*	This method is just to ensure that our testing method
	 *  will return false when passed an array that is not in
	 *  ascending order.
	 */
		int[] numbers = {1, 0};
		assertFalse(isAscending(numbers));
	}

	
	@Test
	public void test0() {
		int[] numbers = new int[0];
		LargestSelectionSort.largestSelectionSort(numbers);
		assertTrue(isAscending(numbers));
	}

	@Test
	public void test1() {
		int[] numbers = new int[1];
		LargestSelectionSort.largestSelectionSort(numbers);
		assertTrue(isAscending(numbers));
	}

	@Test
	public void test2Random() {
		int[] numbers = randomArray(2);
		LargestSelectionSort.largestSelectionSort(numbers);
		assertTrue(isAscending(numbers));
	}

	@Test
	public void test3Random() {
		int[] numbers = randomArray(3);
		LargestSelectionSort.largestSelectionSort(numbers);
		assertTrue(isAscending(numbers));
	}
	
	@Test
	public void test999Random() {
		int[] numbers = randomArray(999);
		LargestSelectionSort.largestSelectionSort(numbers);
		assertTrue(isAscending(numbers));
	}

	@Test
	public void testRepeatValues() {
		int[] numbers = {0, 1, 0, 1, 0};
		LargestSelectionSort.largestSelectionSort(numbers);
		assertTrue(isAscending(numbers));
	}
	
}
