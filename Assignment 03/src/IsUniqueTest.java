/*	IsUniqueTest.java
 *  ITC 155, Seattle Central College, Spring 2018
 *  Peter Caliandro
 *  Assignment 03
 */

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class IsUniqueTest {

	@Test
	public void testHashMapWithoutDuplicates() {
		Map<String, String> testMap = new HashMap<String, String>();

		testMap.put("Marty", "Stepp");
		testMap.put("Stuart", "Reges");
		testMap.put("Jessica", "Miller");
		testMap.put("Amanda", "Camp");
		testMap.put("Hal", "Perkins");

		assertTrue(IsUnique.isUnique(testMap));
	}

	@Test
	public void testHashMapWithDuplicates() {
		Map<String, String> testMap = new HashMap<String, String>();

		testMap.put("Kendrick", "Perkins");
		testMap.put("Stuart", "Reges");
		testMap.put("Jessica", "Miller");
		testMap.put("Bruce", "Reges");
		testMap.put("Hal", "Perkins");

		assertFalse(IsUnique.isUnique(testMap));
	}

	@Test
	public void testTreeMapWithoutDuplicates() {
		Map<String, String> testMap = new TreeMap<String, String>();

		testMap.put("Marty", "Stepp");
		testMap.put("Stuart", "Reges");
		testMap.put("Jessica", "Miller");
		testMap.put("Amanda", "Camp");
		testMap.put("Hal", "Perkins");

		assertTrue(IsUnique.isUnique(testMap));
	}

	@Test
	public void testTreeMapWithDuplicates() {
		Map<String, String> testMap = new TreeMap<String, String>();

		testMap.put("Kendrick", "Perkins");
		testMap.put("Stuart", "Reges");
		testMap.put("Jessica", "Miller");
		testMap.put("Bruce", "Reges");
		testMap.put("Hal", "Perkins");

		assertFalse(IsUnique.isUnique(testMap));
	}

}
