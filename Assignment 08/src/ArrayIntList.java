/*	ArrayIntList.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 08
 */


import java.util.Arrays;

public class ArrayIntList {

//  instance variables
	private int[] elementData;
	private int size;
	public static final int DEFAULT_CAPACITY = 100;
	
	
//  constructors; Java's default constructor would set the array capacity to 0, so we need these constructors
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("capacity: " + capacity);
		}
		this.elementData = new int[capacity];
		size = 0;
	}
	
	
//  methods
	
	//  return the current number of elements in the list
	public int size() {
		return this.size;
	}
	
	//  pre:  0 <= index < size()   
	//  post: return the integer value at the given index in the list 
	public int get(int index) {
		checkIndex(index);
		
		return this.elementData[index];
	}

	//  throw an exception if index is out of range for the size of the current list
	private void checkIndex(int index) {
		if (index < 0  ||  this.size() <= index) {
			throw new IndexOutOfBoundsException();
		}
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + this.elementData[0];
			for (int i = 1; i < this.size; i++) {
				result  +=  ", " + this.elementData[i];
			}
			result += "]";
			
			return result;
		}
	}

	//  return position of first occurrence of value, or -1 if value is not found
	public int indexOf(int value) {
		for (int i = 0; i < this.size; i++) {
			if (this.elementData[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	//  return true if the list is empty
	public boolean isEmpty() {
		return  this.size == 0;
	}
	
	//  return true if value is in the list
	public boolean contains(int value) {
		return  indexOf(value) > -1;
	}
	
	//  insert a value into the list at index
	public void add(int index, int value) {
		checkIndex(index);
		
		ensureCapacity(this.size + 1);
		
		for (int i = this.size; index < i; i--) {
			this.elementData[i] = this.elementData[i - 1];
		}
		this.elementData[index] = value;
		size++;
	}

	//  append a value to the end of the list
	public void add(int value) {
		ensureCapacity(this.size + 1);
		
		this.elementData[this.size] = value;
		size++;
	}

	//  ensure that the array is of given capacity, or else, double the capacity
	private void ensureCapacity(int capacity) {
		if (capacity > this.elementData.length) {
			int newCapacity  =  this.elementData.length * 2  +  1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			this.elementData = Arrays.copyOf(elementData,  newCapacity);
		}	
	}
	
	//  remove the element at a given index; then shift the following elements to the left
	public void remove(int index) {
		checkIndex(index);
		
		for (int i = index; i < this.size - 1; i++) {
			this.elementData[i] = this.elementData[i + 1];
		}
		this.size--;
	}
	
	//  replace value at index with a new value
	public void set(int index, int value) {
		checkIndex(index);
		
		this.elementData[index] = value;
	}
	
	//  empty the list
	public void clear() {
		this.size = 0;
	}
	
	public void addAll(ArrayIntList other) {
		ensureCapacity(this.size + other.size());

		for (int i = 0; i < other.size(); i++) {
			add(i, other.elementData[i]);
		}
	}
	
	public ArrayListIterator iterator() {
		return new ArrayListIterator(this);
	}
	
	
	/*	Assignment 8, #1
	 *  input:        an integer to search for in this ArrayIntList
	 *  output:       the index of the last occurrence of that integer, or else -1 to indicate that the integer was not found
	 *  side effects: none
	 */
	public int lastIndexOf(int find) {
		int index;
		for (index = this.size - 1; 0 <= index; index--) {
			if (this.elementData[index] == find) {
				break;
			}
		}
		return index;  //  index will be -1 by this point if find was never found, which is the intended not found indicator
	}
	
	/*	Assignment 8, #3
	 *  input:        an integer to search for in this ArrayIntList, and second integer to replace it with
	 *  output:       none
	 *  side effects: all occurrences of the first integer have been replaced with the second integer
	 */
	public void replaceAll(int find, int replace) {
		for (int i = 0; i < this.size; i++) {			
			if (this.elementData[i] == find) {
				this.elementData[i] = replace;
			}
		}
	}
	
}
