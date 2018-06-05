/*	Client.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 08
 */


public class Client {

	static public void main(String[] args) {
		int[] array = {0, -9, -7, -6, 5, -2, 4, -4, 8, -2, 7, -4, -1, -1, -2, -2, -5, 2, 6, -3, -6, 2, 2, -2, 5, -2, 5, 9, -5, -3};
		ArrayIntList list = new ArrayIntList(30);
		for (int element : array) {
			list.add(element);
		}
		
		System.out.println(list);
		System.out.println();
		int find    = -11;
		int replace = -97;
		System.out.printf("Last index of %d: %d.\n", find, list.lastIndexOf(find));
		System.out.println();
		
		System.out.printf("Replace %d with %d:\n", find, replace);
		list.replaceAll(find, replace);
		System.out.println(list);
		
	}
	
}
