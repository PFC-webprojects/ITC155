/*	LargestSelectionSort.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 07
 */


import java.util.Arrays;


public class LargestSelectionSort {
	
	public static void main(String[] args) {
	/*	This method is just for initial testing of largestSelectionSort(). 
	 */
		int[] tryThese = LargestSelectionSortTest.randomArray(9);  //  {0, 1, 0, 1, 0};  //  {24, -427, 39, 0, -43, -49, -975, 2947, 3};
		System.out.println(Arrays.toString(tryThese));
		largestSelectionSort(tryThese);
		System.out.println(Arrays.toString(tryThese));
	}

	
	public static void largestSelectionSort(int[] numbers) {
	/*	Sort an array of ints in-place.
	 * 
	 *  "A modified version of the selection sort algorithm that
	 *  selects the largest element each time and moves it to the
	 *  end of the array."
	 *  
	 * 	This algorithm is no faster than the standard selection
	 *  sort.  Its complexity class is still quadratic, as it
	 *  relies on a pair of nested loops. 
	 */
		for (int i = numbers.length - 1; 0 < i; i--) {
			int maximum = i;
			for (int j = 0; j < i; j++) {
				if (numbers[maximum] < numbers[j]) {
					maximum = j;
				}
			}
			if (maximum != i) {
				swap(numbers, i, maximum);
			}
		}
	}
	
	private static void swap(int[] numbers, int first, int second) {
	/*	Swap two int array values as indexed by first and second.
	 */
		int temporary   = numbers[first];
		numbers[first]  = numbers[second];
		numbers[second] = temporary;
	}
	
}
