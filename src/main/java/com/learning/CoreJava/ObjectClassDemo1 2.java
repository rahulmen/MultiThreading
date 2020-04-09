/*
 * Thsi program demostrate number of method present in Object Class.
 * It is a rooti Class of every Object Class and has 12 methods
 * 
    finalize
	wait
	wait
	wait
	equals
	toString
	hashCode
	getClass
	clone
	notify
	notifyAll
	registerNatives(Used only by Object Class)
 */


package com.learning.CoreJava;

import java.lang.reflect.Method;

public class ObjectClassDemo1 {
	
	
	public static void main(String[] args) {
		
		try {
		Class.forName("java.lang.String"); //Loading Object Class.
		}catch(ClassNotFoundException nsee) {
			nsee.printStackTrace();
		}
		String obj = new String();
		
		Method[] m = obj.getClass().getDeclaredMethods();
		
		for(Method m1 : m) {
			System.out.println(m1.getName());
		}
		
		
	}

}
