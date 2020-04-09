package com.learning.collection;

import java.util.Hashtable;

class Demo {
	
	int i;
	
	public Demo(int i){
		this.i=i;
	}
	
	public int hashCode() {
		return i;
	}
	
	public String toString() {
		return i+"";
	}
	
}



public class HashTableExample1 {
	
	public static void main(String[] args) {
		
		Hashtable<Demo,String> ht = new Hashtable<Demo,String>(); //Default capacity is 11
		ht.put(new Demo(1), "Test1");
		ht.put(new Demo(11), "Test2");
		ht.put(new Demo(5), "Test3");
		ht.put(new Demo(9), "Test4");
		
		System.out.println(ht);
		
		
		
	}

}
