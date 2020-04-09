package com.learning.collection;

import java.util.Comparator;
import java.util.TreeMap;

class MyComparator1 implements Comparator<Object>{

	@Override
	public int compare(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		String int1 = (String)obj1;
		String int2 = (String)obj2;
		return -(int1.compareTo(int2));
	}
	
}


public class TreeMapExample {

	
	
	public static void main(String...args) {
		
		TreeMap<Object,String> m = new TreeMap<Object,String>(new MyComparator1());
		m.put("105", "AAA");
		m.put("106", "BBB");
		m.put("108", "ZZZ");
		m.put("101", "CCC");
		m.put("ZZZ", "123");
		System.out.println(m);

	}

}
