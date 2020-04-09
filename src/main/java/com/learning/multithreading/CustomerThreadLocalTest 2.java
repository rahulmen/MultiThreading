package com.learning.multithreading;

 class CustomerThreadLocalTest extends Thread {
	
	private static ThreadLocal obj = new ThreadLocal() {
		
		int customerId=0;
		
		protected Object initialValue() {
			return ++customerId;
		}
		
	};

	public CustomerThreadLocalTest(String threadName) {
		super(threadName);
	}
	
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " has been assigned a customer_id equals to " + obj.get());
		
	}

}







