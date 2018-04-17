/*	Partition.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 02
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Partition {

	public static void main(String[] args) {
		Integer testInts[] = {-1, 1, 342, -34298, 42, 573, 3498, -427, -478};
		List<Integer> testList;
		
		testList = new ArrayList<Integer>();
		Collections.addAll(testList, testInts);
		mainTest(testList);
		
		System.out.println();
		
		testList = new LinkedList<Integer>();
		Collections.addAll(testList, testInts);
		mainTest(testList);
	}
	
	private static void mainTest(List<Integer> testList) {
		System.out.println(testList);
		partition(testList, 0);
		System.out.println(testList);
	}
	
	
	
	public static boolean partition(List<Integer> listIntegers, int partitionValue) {
	//  Given a list of Integers (listIntegers) and an int (partitionValue),
	//	rearrange listIntegers so that all elements with value less than partitionValue
	//  occur before all elements with value greater than partitionValue.
	//  For efficiency, delegate this generic List method to either
	//  a method optimized for an ArrayList or a method optimized for a LinkedList.
		boolean successfulPartitioning = true;
		
		switch (listIntegers.getClass().getName()) {
			case "java.util.ArrayList":
				arrayListPartition(listIntegers, partitionValue);
				break;
			case "java.util.LinkedList":
				linkedListPartition(listIntegers, partitionValue);
				break;
			default:
				successfulPartitioning = false;
				break;
		}
		
		return successfulPartitioning;
	}
	
	private static void arrayListPartition(List<Integer> arrayListIntegers, int partitionValue) {
	//  Take advantage of the ArrayList's speed in accessing elements via index by swapping items
	//  that are out of place toward the beginning of the ArrayList with those that are out of place
	//  toward the end of the ArrayList. 
		int i  =  -1;  //  Index i counts forward from the beginning of the ArrayList.
		int j  =  arrayListIntegers.size() - 1;  //  Index j counts backwards from the end of the ArrayList.
		while (++i < j) {  //  Once i has been incremented to the point where it equals or exceeds j, there should be no values left that will need to be swapped.
			if (partitionValue < arrayListIntegers.get(i)) {  //  then this element toward the beginning of the ArrayList is out of place and may need to be swapped with an out-of-place element toward the end of the list -- if there is one. 
				while (i < j  &&  partitionValue < arrayListIntegers.get(j)) {  //  Once j has been decremented to the point where it equals i, there should be no values left that will need to be swapped.
					j--;
				}
				if (i < j) {  //  then we must have exited the above while loop because we found an element toward the end of the list, indexed by j, that is out of place and may be swapped with the element indexed by i. 
					Collections.swap(arrayListIntegers, i, j--);  //  Since we have swapped the element indexed by j, there will be no need to revisit this element any more, so we may as well take this opportunity to decrement j now.
				}
			}
		}
	}

	private static void linkedListPartition(List<Integer> linkedListIntegers, int partitionValue) {
	//  Take advantage of the LinkedList's speed in shifting node indices and adding new elements 
	//  to the end by removing nodes that are out of place and eventually adding them to the end
	//  of the LinkedList again. 
		LinkedList<Integer> greaterList = new LinkedList<Integer>();
		
		Iterator<Integer> itr = linkedListIntegers.iterator();
		while (itr.hasNext()) {
			int thisInt = itr.next();
			if (partitionValue < thisInt) {  //  then thisInt should occur later in the list.
				itr.remove();
				greaterList.add(thisInt);  //  Elements of greaterList will be added to the end of linkedListIntegers.
			}
		}
		linkedListIntegers.addAll(greaterList);
	}

}
