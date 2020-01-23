/*
 * This Program demonstrate the importance of Iterator cursor to print odd values in arrayList and will remove even values while iterating.
 * Iterator is a universal cursor
 */

package com.learning.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample1 {

	private static ArrayList<Object> al = new ArrayList<Object>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	private static Iterator<Object> itr;

	public static  void ListIterator(List<Object> l) {
		IteratorExample1.itr = l.iterator();
		 
		 while(itr.hasNext()) {
			 
			 Integer i = (Integer)itr.next();
			 
			if(i%2==1) {
				System.out.print(i + " ");
			}
			else {
				itr.remove();
			}
		 }
		 
		 System.out.println("\n"+l);


	}


	public static void main(String[] args) {

		IteratorExample1.ListIterator(al);


	}

}
