/*
 * This program demostrate importance of equals() method 
 * The equals() method implemented in Object class is meant for reference comparison but class like String has overrided equals() method for reference Comparison.
 * 
 */



package com.learning.CoreJava;

public class EqualsMethodDemo1 {
	
	String name;
	int rollNum;
	
	public EqualsMethodDemo1(String name,int rollNum) {
		this.name=name;
		this.rollNum = rollNum;
	}
	
	/*
	 * Overriding Equals Methods technique 1

	public boolean equals(Object obj) {
		try {
		EqualsMethodDemo1 obj1 = (EqualsMethodDemo1)obj;
		if(this.name.equals(obj1.name)&&this.rollNum==obj1.rollNum) { //We can eliminate "this" Keyword also 
			return true;
		}
		else {
			return false;
		}
		}catch(NullPointerException nsee) {
			return false;
		}catch(ClassCastException nsee) {
			return false;
		}
		}
	
	*/
	
	/*
	  Overriding Equals Methods technique 2
*/
	
	public boolean equals(Object obj) {
		
		if(this==obj) {
			return true;
		}
		if(obj instanceof EqualsMethodDemo1) {
			EqualsMethodDemo1 obj1 = (EqualsMethodDemo1)obj;
			if(name.equals(obj1.name)&&rollNum==obj1.rollNum) {
				return true;
			}
			else {
				return false;
			}
	
		}
		return false;
		
		}
		
	
	
	
	
	public static void main(String[] args) {
		
		EqualsMethodDemo1 s1 = new EqualsMethodDemo1("Rahul",10);
		EqualsMethodDemo1 s2 = new EqualsMethodDemo1("Mendiratta",100);
		EqualsMethodDemo1 s3 = new EqualsMethodDemo1("Rahul",10);
		EqualsMethodDemo1 s4=s1;
		EqualsMethodDemo1 s5= null;
		String s6 = new String("StringObject");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals(s5));
		System.out.println(s1.equals(s6));
		
		
	}

}
