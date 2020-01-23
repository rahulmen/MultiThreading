package com.learning.multithreading;

public  class CustomerThreadLocalExample2{

	public static void main(String[] args) {

		CustomerThreadLocalTest obj1 = new CustomerThreadLocalTest("Customer Thread 1");
		CustomerThreadLocalTest obj2 = new CustomerThreadLocalTest("Customer Thread 2");
		CustomerThreadLocalTest obj3 = new CustomerThreadLocalTest("Customer Thread 3");
		CustomerThreadLocalTest obj4 = new CustomerThreadLocalTest("Customer Thread 4");
		obj1.start();
		obj2.start();
		obj3.start();
		obj4.start();
		
	}
}