package com.learning.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class ListSearchingExample1{

	public static void main(String... args) {

		ArrayList<Character> al = new ArrayList<Character>(Arrays.asList('J','K','Q','a','M','W','L'));
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
		System.out.println(Collections.binarySearch(al, 'a'));
		System.out.println(Collections.binarySearch(al, 'J'));
		System.out.println(Collections.binarySearch(al, 'T'));
		Collections.sort(al,new MyComparator5());
		System.out.println(Collections.binarySearch(al, 'a',new MyComparator5()));
		System.out.println(Collections.binarySearch(al, 'J',new MyComparator5()));
		System.out.println(Collections.binarySearch(al, 'T',new MyComparator5()));
	}

}

class MyComparator5 implements Comparator<Object>{
	
	@Override
	public int compare(Object obj1,Object obj2) {
		Character i1 = (Character)obj1;
		Character i2 = (Character)obj2;
		return i2.compareTo(i1);
	}
	
}