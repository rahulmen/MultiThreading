/*
 * This program demonstrate importance of toString() method that is present in Object Class which is direct or indirect root class of every Java Class.
 * WhenEver we try to print any Object reference then internally toString() method is called   
 * Every wrapper Class(Integer,String,Double,Float,Boolean) has already overrided toString() method to return the value
 * 
 * 
 * Default implementation present in Object Class :
 *		public String toString(){
 *			return getClass().getName()+"@"+Integer.toHexString(hascode());
 *					}
 *
 *
 *We can Override toString() method to return values
 *
 *Override implementation present in this Class :
 *		@Override
 *		public String toString() {
 *		return name;
 *						}
 *
 *
 *It is always good practice to override toString() method in our Java Class
 */


package com.learning.CoreJava;

import java.util.ArrayList;
import java.util.Arrays;

public class ToStringDemo1 extends Object{

	String name;

	public ToStringDemo1(String name) {
		this.name=name;	
	}

	//Overriding toString() method to return name
	@Override
	public String toString() {
		return name;
	}


	public static void main(String[] args) {


		Integer i = new Integer(10);
		System.out.println(i);
		ArrayList<Object> al = new ArrayList<Object>(Arrays.asList("rahul","mendiratta"));
		System.out.println(al);
		ToStringDemo1 obj1 = new ToStringDemo1("TestObject1");
		System.out.println(obj1);  //return com.learning.CoreJava.ToStringDemo1@15db9742 when toString() method is not overridden




	}




}
