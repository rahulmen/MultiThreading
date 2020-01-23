/*
 * This program demostrate importance of Singelton Class 
 * Rule 1 :- Define constructor as private so that ono other class will not created instance of this singelton class.
 * Define public getInstance Method that will return Object for SingeltoneClass.
 */


package com.learning.CoreJava;

public class SingeltonClassDemo1 {
	
	//Define Static because we want only 1 Object for complete class
	public static SingeltonClassDemo1 singletonObject = null;
	
	public String s;
	
	// Defined private to limit it to this class only
	private SingeltonClassDemo1() {
		s = "This is the Demo Singeltone Class";
	}

	
	public static SingeltonClassDemo1 SingeltoneGetInstance() {
		if(singletonObject==null) {
			singletonObject = new SingeltonClassDemo1();
		}
		return singletonObject;
	}
	
	
	public static void main(String... args) {
		
		
		SingeltonClassDemo1 obj1 = SingeltonClassDemo1.SingeltoneGetInstance();
		SingeltonClassDemo1 obj2 = SingeltonClassDemo1.SingeltoneGetInstance();
		SingeltonClassDemo1 obj3 = SingeltonClassDemo1.SingeltoneGetInstance();
		
		obj1.s = obj1.s.toLowerCase();
		
		System.out.println(obj1.s);
		System.out.println(obj2.s);
		System.out.println(obj3.s);
		
		obj3.s = obj3.s.toUpperCase();
		
		System.out.println(obj1.s);
		System.out.println(obj2.s);
		System.out.println(obj3.s);


	}

}

