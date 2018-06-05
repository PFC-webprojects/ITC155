/*	ArrayListIterator.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 08
 */


import java.util.NoSuchElementException;


public class ArrayListIterator {
//  Provide a set of utilities for iterating.
//	This iterator will not be created in the background when a for each loop is run, though.
//	It is more like the type of iterator that is used with System.in .
	
	
	//  instance variables
	private ArrayIntList list;  	//  the ArrayIntList we are iterating over
	private int 		 position;  //  the current position in the iteration
	private boolean 	 removeOK;  //  whether we may remove the current element
	
	
	//  constructor
	public ArrayListIterator (ArrayIntList list) {
		this.list 	  = list;
		this.position = 0;
		this.removeOK = false;
	}
	
	
	public boolean hasNext() {
		return  this.position < list.size();
	}
	
	
	//  pre:  hasNext()
	//  post: return the next element in the iteration
	public int next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		int result = this.list.get(this.position);
		this.position++;
		removeOK = true;
		return result;
	}
	
	
	//  pre:  next() has been called without a call on remove()
	public void remove() {
		if(!this.removeOK ) {
			throw new IllegalStateException();
		}
		list.remove(position - 1);
		this.position--;
		this.removeOK = false;
	}

	
}
