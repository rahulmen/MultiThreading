/*
 * This program demonstrate how we use Enumeration cursor for iterating over element present in Vector.
 * Enumeration is a legacy Cursor that we use for legacy Classes like Vector. 
 */


package com.learning.collection;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationExample1 {
	
	public static void main(String[] args) {
		
		
		Vector<Object> v = new Vector<Object>();

		for(int i=0;i<=10;i++) {
			v.addElement(i);
		}
		
		System.out.println(v);
		
		Enumeration<Object> e = v.elements();
		
		while(e.hasMoreElements()) {
			
			Integer i = (Integer)e.nextElement();
			
			if(i%2==0) {
				System.out.print(i+ " ");
			}
			
		}
		
		
	}

}
