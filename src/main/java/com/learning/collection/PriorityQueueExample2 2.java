/*
 * Queue Example that depends on Customized Sorting Technique
 */

package com.learning.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample2 {

	private static Queue<Object> q = new PriorityQueue<Object>(15,new MyComparator2()); 

	public Queue<Object> getQueue() {
		return q;
	}

	public static void main(String... args) {
		System.out.println(q);
		q.offer("X");
		q.offer("A");
		q.offer("S");
		q.offer("L");
		System.out.println(q);
		

	}
}


class MyComparator2 implements Comparator<Object> {
	

	@Override
	public int compare(Object obj1, Object obj2) {
		String str1 = (String)obj1;
		String str2 = obj2.toString();
		return str2.compareTo(str1);
	}
	
}