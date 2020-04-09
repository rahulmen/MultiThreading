/*
 * Queue Example that depends on Default Natural Sorting Order
 */

package com.learning.collection;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample1 {

	private static Queue<Object> q = new PriorityQueue<Object>(); 

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
		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.peek());
		System.out.println(q);

	}
}