/*
 * This proogram demostrate how we can use SortedSet Interface if we want insertion opder to be preserved and duplicate are not allowed in normal Set insertion order and duplicate
 * both are not allowed
 *
 */



package com.learning.collection;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExmple1 {

	private static SortedSet<Object> s = new TreeSet<Object>(Arrays.asList(2,3,4,2,3,1,3,4,32,2));
	
	public static void getSortedSet(SortedSet<Object> s1) {
		
		System.out.println(s1); // Implemented default natural sorting for integer that is ascending Order.
		System.out.println(s1.last());
		
		
	}
	
	
	public static void main(String...args) {
		
	System.out.println(s.subSet(3, 32));	

		SortedSetExmple1.getSortedSet(s);
		
	}
}
