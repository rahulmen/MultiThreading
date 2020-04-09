package com.learning.multithreading;

public class ThreadLocalExample1{


	public static void main(String[] args) {

		//Created ThreadLocal Class Object
		ThreadLocal local_obj = new ThreadLocal() {
			//Using anonymous class concept override the initialValue method present in ThreadLocal Class.
			@Override
			protected Object initialValue() {
				return "ravi";
			}


		};
		System.out.println(local_obj.get()); //null as no value has been initilaized but as we have overrided initialValue() method it will return ravi now
		local_obj.set("Thread Main Local Object"); //Set ThreadLocal variable name
		System.out.println(local_obj.get()); 
		local_obj.remove();	// removed the thread local variable name
		System.out.println(local_obj.get()); //Will return initialValue set in overrided method.

	}

}
