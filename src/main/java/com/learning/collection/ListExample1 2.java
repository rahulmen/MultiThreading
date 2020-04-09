package com.learning.collection;

import java.util.Vector;

class CollectionThread extends Thread{
	Vector v = new Vector();
	
	
	
	public synchronized void run() {
		
		//synchronized(this) {
		v.addAll(CollectionClass1.al);
		System.out.println(v.size());
		v.removeAll(CollectionClass1.al);
		System.out.println(v.size());
		//}
	}
}

public class ListExample1 {
	
	public   static void main(String[] args) {
		
		
		CollectionThread t1 = new CollectionThread();
		CollectionThread t2 = new CollectionThread();
		t1.start();
		t2.start();
		
		
	}

}
