/*
 * Program to show case function in Collection Interface and searching using iterator
 */

package com.learning.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class CollectionClass1 {


	static CollectionClass1 collectionObject = new CollectionClass1();

	static Collection<Object> al = new ArrayList<Object>(Arrays.asList(1,2,3,4,3,2,43,32,3,4,3,2,3,3,2,4,43,34,343,3,3));

	//Function that return count of number from ArrayList
	public int getNumberCount(Collection<Object> passedList) {
		//ArrayList<Object> mainList = (ArrayList<Object>)passedList;
		Iterator<Object> itr = passedList.iterator();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The number to search : ");
		int number = scan.nextInt();
		scan.close();
		int count=0;
		while(itr.hasNext()) {
			if(itr.next().equals(number)) {
				count++;
			}
		}
		return count;
	}

	/*
	 * Function to return CollectionClass1 instance 
	 */

	public static CollectionClass1 getInstance() {

		return collectionObject;
	}

	public static void main(String[] args) { 

		al.add(343223);
		al.remove(3);
		System.out.println(al);
		//System.out.println(al.isEmpty());
		//System.out.println(System.getProperty("user.dir"));
		//System.out.println(al.contains(2));
		//al.removeAll(al);
		//System.out.println(al);
		//System.out.println(al.isEmpty());

		System.out.println("The count of number is "+ CollectionClass1.getInstance().getNumberCount(al));

		//--------------------------------------





	}



}
