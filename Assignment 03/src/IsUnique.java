/*	IsUnique.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 03
 */


import java.util.HashSet;
import java.util.Map;

public class IsUnique {

	public static boolean isUnique(Map<String, String> inputMap) {
		//  Return true if no two keys of the parameter inputMap map to the same value.
		//  In other words, if inputMap contains any duplicate values, then return false.
		//  To compute this:  If inputMap's collection of values contains any duplicates,
		//  then any HashSet constructed from it will have fewer elements than the inputMap's
		//  collection of values that it was constructed from, as a HashSet will not accept
		//  any duplicates.  Likewise, if inputMap's collection of values does not contain any
		//  duplicates, then any HashSet constructed from it will have the same number
		//  of elements.  So create that HashSet and test for equality of size. 
		return  inputMap.size() == (new HashSet<>(inputMap.values())).size();
	}
	
}
