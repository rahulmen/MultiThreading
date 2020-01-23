/*
 * In ArrayList insertion order is maintained and duplicates are allowed
 * Program demostrate how we can use ArrayList to store String Object in it 
 */

package com.learning.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample1 {

	static ArrayList<String> al;
	static List<String> al1;


	static void addToArrayList(String name) {
		char[] ch = name.toCharArray(); //Converted String into Char array
		char[] ch1 = new char[ch.length];
		String tempName=null;
		for(int i=0;i<ch.length;i++) { //Iterating over first String
			if(!(ch[i]=='Z' || ch[i]=='z')) {  //Condition to check if it doesnot contain Z
				ch1[i]=ch[i];
			}else {
				continue;
			}
			tempName = new String(ch1);
		}
		String finalName = tempName.replaceAll(" ","");
		al.add(finalName);
		
		//Add condition for specific character
	}


	public static void main(String[] args) {

		al = new ArrayList<String>();
		al1 = Collections.synchronizedList(al);

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number od String to be added :");
		int size = scan.nextInt();
		System.out.println("Enter the string value to be added");

		for(int i =0;i<size;i++) {
			String value = scan.next();
			addToArrayList(value);
		}
		scan.close();
		System.out.println(al1);


	}

}
