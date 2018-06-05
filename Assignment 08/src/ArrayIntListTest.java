/*	ArrayIntListTest.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 08
 */


import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayIntListTest {


	static public ArrayIntList createListOne30() {
		int[] array = {-3, -2, -1, -1, -8, 1, 3, -5, 3, -9, -2, 0, 5, -9, 2, 5, -5, 1, 3, 3, -4, -8, -7, -8, -8, -7, -2, 4, -4, 7};
		ArrayIntList list = new ArrayIntList(30);
		for (int element : array) {
			list.add(element);
		}		
		
		return list;
	}
	
	
	static public ArrayIntList createListTwo30() {
		int[] array = {-3, -2, -1, -1, -8, 0, -3, -5, 3, -9, -2, 0, 0, -9, 2, 5, -5, 1, 3, 3, -4, -8, 7, -8, -8, -7, -2, 4, -4, 7};
		ArrayIntList list = new ArrayIntList(30);
		for (int element : array) {
			list.add(element);
		}		
		
		return list;
	}
	
	

/*	Test the ArrayIntList.lastIndexOf() method on values that appear once or many times
 * 	crossed with those values occurring at the end of the list, in the middle of the list,
 *  or at the beginning of the list.  Also test using a list of size 1, a list of capacity
 *  1 and size 0, and a list of capacity 0.
 */
	
	@Test
	public void lastIndexOfLastOnly() {
		assertEquals(createListOne30().lastIndexOf(7), 29);
	}

	@Test
	public void lastIndexOfMiddleOnly() {
		assertEquals(createListOne30().lastIndexOf(0), 11);
	}

	@Test
	public void lastIndexOfFirstOnly() {
		assertEquals(createListOne30().lastIndexOf(-3), 0);
	}

	@Test
	public void lastIndexOfLastMany() {
		assertEquals(createListTwo30().lastIndexOf(7), 29);
	}

	@Test
	public void lastIndexOfMiddleMany() {
		assertEquals(createListTwo30().lastIndexOf(0), 12);
	}

	@Test
	public void lastIndexOfFirstMany() {
		assertEquals(createListTwo30().lastIndexOf(-3), 6);
	}

	@Test
	public void lastIndexOfNotFound() {
		assertEquals(createListTwo30().lastIndexOf(6), -1);
	}

	@Test
	public void lastIndexOfOne() {
		ArrayIntList list = new ArrayIntList(1);
		list.add(0);
		assertEquals(list.lastIndexOf(0), 0);
	}

	@Test
	public void lastIndexOfZeroOne() {
		ArrayIntList list = new ArrayIntList(1);
		assertEquals(list.lastIndexOf(0), -1);
	}

	@Test
	public void lastIndexOfZeroZero() {
		ArrayIntList list = new ArrayIntList(0);
		assertEquals(list.lastIndexOf(0), -1);
	}

	

/*	Test the ArrayIntList.replaceAll() method on values that appear once or many times
 * 	crossed with those values occurring at the end of the list, in the middle of the list,
 *  or at the beginning of the list.  Also test using a list of size 1, a list of capacity
 *  1 and size 0, and a list of capacity 0.
 */

	@Test
	public void replaceAllLastOnly() {
		ArrayIntList list = createListOne30();
		list.replaceAll(7, 10);
		assertEquals(
			list.toString(), 
			"[-3, -2, -1, -1, -8, 1, 3, -5, 3, -9, -2, 0, 5, -9, 2, 5, -5, 1, 3, 3, -4, -8, -7, -8, -8, -7, -2, 4, -4, 10]"
		);
	}

	@Test
	public void replaceAllMiddleOnly() {
		ArrayIntList list = createListOne30();
		list.replaceAll(0, 10);
		assertEquals(
			list.toString(), 
			"[-3, -2, -1, -1, -8, 1, 3, -5, 3, -9, -2, 10, 5, -9, 2, 5, -5, 1, 3, 3, -4, -8, -7, -8, -8, -7, -2, 4, -4, 7]"
		);
	}
	
	@Test
	public void replaceAllFirstOnly() {
		ArrayIntList list = createListOne30();
		list.replaceAll(-3, 10);
		assertEquals(
			list.toString(), 
			"[10, -2, -1, -1, -8, 1, 3, -5, 3, -9, -2, 0, 5, -9, 2, 5, -5, 1, 3, 3, -4, -8, -7, -8, -8, -7, -2, 4, -4, 7]"
		);
	}

	@Test
	public void replaceAllLastMany() {
		ArrayIntList list = createListTwo30();
		list.replaceAll(7, 10);
		assertEquals(
			list.toString(),
			"[-3, -2, -1, -1, -8, 0, -3, -5, 3, -9, -2, 0, 0, -9, 2, 5, -5, 1, 3, 3, -4, -8, 10, -8, -8, -7, -2, 4, -4, 10]"
		);
	}

	@Test
	public void replaceAllMiddleMany() {
		ArrayIntList list = createListTwo30();
		list.replaceAll(0, 10);
		assertEquals(
			list.toString(),
			"[-3, -2, -1, -1, -8, 10, -3, -5, 3, -9, -2, 10, 10, -9, 2, 5, -5, 1, 3, 3, -4, -8, 7, -8, -8, -7, -2, 4, -4, 7]"
		);
	}

	@Test
	public void replaceAllFirstMany() {
		ArrayIntList list = createListTwo30();
		list.replaceAll(-3, 10);
		assertEquals(
			list.toString(),
			"[10, -2, -1, -1, -8, 0, 10, -5, 3, -9, -2, 0, 0, -9, 2, 5, -5, 1, 3, 3, -4, -8, 7, -8, -8, -7, -2, 4, -4, 7]"
		);
	}

	@Test
	public void replaceAllNotFound() {
		ArrayIntList list = createListTwo30();
		list.replaceAll(6, 10);
		assertEquals(
			list.toString(),
			"[-3, -2, -1, -1, -8, 0, -3, -5, 3, -9, -2, 0, 0, -9, 2, 5, -5, 1, 3, 3, -4, -8, 7, -8, -8, -7, -2, 4, -4, 7]"
		);
	}
	
	@Test
	public void replaceAllOne() {
		ArrayIntList list = new ArrayIntList(1);
		list.add(0);
		list.replaceAll(0, 10);
		assertEquals(list.toString(), "[10]");
	}
	
	@Test
	public void replaceAllZeroOne() {
		ArrayIntList list = new ArrayIntList(1);
		list.replaceAll(0, 10);
		assertEquals(list.toString(), "[]");
	}
	
	@Test
	public void replaceAllZeroZero() {
		ArrayIntList list = new ArrayIntList(0);
		list.replaceAll(0, 10);
		assertEquals(list.toString(), "[]");
	}	

}
