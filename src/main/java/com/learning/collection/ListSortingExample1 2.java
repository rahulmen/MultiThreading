package com.learning.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortingExample1 {

	
	public static void main(String[] args) {
		
		
		List<Integer> al = new ArrayList<Integer>(Arrays.asList(3,1,6,3,7,23,4));
		System.out.println(al);
		Collections.sort(al); //Sort List as per Default Natural Sorting Technique
		System.out.println(al);
		Collections.sort(al, new MyComparator4()); //Sorting as per customized Sorting Technique
		System.out.println(al);
		
	}}

class MyComparator4 implements Comparator<Object>{
	
	@Override
	public int compare(Object obj1,Object obj2) {
		Integer i1 = (Integer)obj1;
		Integer i2 = (Integer)obj2;
		return i2.compareTo(i1);
	}
	
}