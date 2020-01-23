/*
 * Navigable
 */


package com.learning.collection;

import java.util.Arrays;
import java.util.TreeSet;

public class NavigableSetExamples1 {
	
	static TreeSet<Object> ns = new TreeSet<Object>(Arrays.asList("CCC","AAA","HHH","LLL","DDD"));
	
	public static void main(String... args) {
		
		System.out.println(ns);
		System.out.println(ns.ceiling("JJJ"));
		System.out.println(ns.floor("CCC"));
		System.out.println(ns);
		System.out.println(ns.lower("CCC"));
		System.out.println(ns.higher("CCC"));
		System.out.println(ns);
		System.out.println(ns.descendingSet());
		System.out.println(ns.pollFirst());
		System.out.println(ns.pollLast());
		System.out.println(ns.descendingSet());
		
		
		
		
	}

}
