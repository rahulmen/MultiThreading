/*
 * This program demonstrate how to use hasCode() method present in Object Class to store Object in hashing related DataStructure.
 * 
 * Ideally hasCode() method don't store the address of the Object. JVM assigned a unique number to every Object for storing those Object in Hashing related DataStructure like
 * HashMap,HashTable,HashSet.
 * 
 * In default implementation of hashCode() method present in Object Class. JVM uses address only to assign a unique number to an Object.
 * 
 * It our frequent Operation is search operation than Hashing related DataStructure is always best Approach because element can be find with COmplexity of O(1).
 * As each element has different hashCode() element will be stored in different buckets so when searched direct that bucket can be approached.
 *
 */


package com.learning.CoreJava;

import java.util.HashSet;

public class HashCodeDemo1 {
	
	int roolnum;
	String name;
	
	public HashCodeDemo1(int roolnum,String name){
		this.roolnum=roolnum;
		this.name=name;
	}
	
	@Override
	public String toString() {
		return roolnum + "...." + name;
	}
	
	@Override
	public int hashCode() {
		return roolnum;
	}
	
	
	public static void main(String[] args) {
		HashCodeDemo1 obj1 = new HashCodeDemo1(10,"Rahul");
		HashCodeDemo1 obj2 = new HashCodeDemo1(100,"Mendiratta");
		System.out.println(obj1);
		System.out.println(obj2);
		//Storing this objects into Hashing DataStructure
		
		HashSet<Object> hs = new HashSet<Object>();
		hs.add(obj1);
		hs.add(obj2);
		System.out.println(hs); //[100....Mendiratta, 10....Rahul]
		
		
	}

}
