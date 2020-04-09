
/*
 * Defined our Own Default Natural Sorting Order
 */


package com.learning.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class NavigableMapExample1 {
	
	static TreeMap<String,String> tm = new TreeMap<String,String>(new MyComparator3());
	
	public static void main(String... args) {
		
		tm.put("A", "Apple");
		tm.put("D", "Dog");
		tm.put("Z", "Zebra");
		tm.put("L", "Lion");
		System.out.println(tm);
		System.out.println(tm.ceilingKey("K"));
		System.out.println(tm.floorKey("U"));
		System.out.println(tm);
		System.out.println(tm.lowerKey("A"));
		System.out.println(tm.higherKey("A"));
		System.out.println(tm);
		System.out.println(tm.descendingMap());
		System.out.println(tm.pollFirstEntry());
		System.out.println(tm.pollLastEntry());
		System.out.println(tm);
		
		
	}

}

class MyComparator3 implements Comparator<Object>{
	
	public int compare(Object obj1,Object obj2) {
		String str1 = (String)obj1;
		String str2 = obj2.toString();
		
		return str2.compareTo(str1);
	}
	
}
