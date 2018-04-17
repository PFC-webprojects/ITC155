/*	PartitionTest.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 02
 */


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.*;

public class PartitionTest {

	@Test
	public void arrayList_0_Elements() {
		List<Integer> testList = new ArrayList<Integer>();
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void linkedList_0_Elements() {
		List<Integer> testList = new LinkedList<Integer>();
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void arrayList_1_ElementLessThanPartitionValue() {
		List<Integer> testList = new ArrayList<Integer>();
		Integer[] testInts = {-1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void linkedList_1_ElementLessThanPartitionValue() {
		List<Integer> testList = new LinkedList<Integer>();
		Integer[] testInts = {-1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void arrayList_1_ElementGreaterThanPartitionValue() {
		List<Integer> testList = new ArrayList<Integer>();
		Integer[] testInts = {1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void linkedList_1_ElementGreaterThanPartitionValue() {
		List<Integer> testList = new LinkedList<Integer>();
		Integer[] testInts = {1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void arrayList_2_ElementsSurroundingPartitionValueInOrder() {
		List<Integer> testList = new ArrayList<Integer>();
		Integer[] testInts = {-1, 1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void linkedList_2_ElementsSurroundingPartitionValueInOrder() {
		List<Integer> testList = new LinkedList<Integer>();
		Integer[] testInts = {-1, 1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void arrayList_2_ElementsSurroundingPartitionValueOutOfOrder() {
		List<Integer> testList = new ArrayList<Integer>();
		Integer[] testInts = {1, -1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void linkedList_2_ElementsSurroundingPartitionValueOutOfOrder() {
		List<Integer> testList = new LinkedList<Integer>();
		Integer[] testInts = {1, -1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void arrayList_2_ElementsLessThanPartitionValue() {
		List<Integer> testList = new ArrayList<Integer>();
		Integer[] testInts = {-11, -1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void linkedList_2_ElementsLessThanPartitionValue() {
		List<Integer> testList = new LinkedList<Integer>();
		Integer[] testInts = {-11, -1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void arrayList_2_ElementsGreaterThanPartitionValue() {
		List<Integer> testList = new ArrayList<Integer>();
		Integer[] testInts = {11, 1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void linkedList_2_ElementsGreaterThanPartitionValue() {
		List<Integer> testList = new LinkedList<Integer>();
		Integer[] testInts = {11, 1};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void arrayListRandom() {
		List<Integer> testList = new ArrayList<Integer>();
		Integer[] testInts = {3427, 983, 428, -42798, -234, 49, 289, -3928};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	@Test
	public void linkedListRandom() {
		List<Integer> testList = new LinkedList<Integer>();
		Integer[] testInts = {3427, 983, 428, -42798, -234, 49, 289, -3928};
		Collections.addAll(testList, testInts);
		Partition.partition(testList, 0);
		assertTrue(testForSuccessfulPartitioning(testList, 0));
	}

	
	
	
	
	private boolean testForSuccessfulPartitioning(List<Integer> testList, int partitionValue) {
	//  Check each element of testList in order from the beginning toward the end.
	//  As soon as an element is found that is greater than partitionValue, make note of that.
	//  From that point, every following element should also be greater than partitionValue.
	//  If any element is found thereafter that is less than partitionValue, then the test
	//  returns false.  Otherwise, it returns true.
		boolean succeeded = true;
		boolean exceededPartitionValueAlready = false;

		for (int currentValue : testList) {
			if (exceededPartitionValueAlready) {
				if (currentValue < partitionValue) {
					succeeded = false;
					break;
				}
			} else {
				if (partitionValue < currentValue) {
					exceededPartitionValueAlready = true;
				}				
			}
		}
		
		return succeeded;
	}
}
