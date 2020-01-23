/*
 * This program demonstrate how we use ThreadPoolExecutor present in java.util.concurrent to so that same thread can be used multiple times for exection
 */


package com.learning.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class MyRunnable21 implements Runnable{

	String name;

	MyRunnable21(String name){
		this.name=name;
	}


	public void run() {

		System.out.println(Thread.currentThread().getName()+ " start execution of " + name);		

		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " completed execution of" + name);
	}


}

public class ThreadPoolExample1 {

	public static void main(String[] args) {

		
		//Created ThreadPool of size 3 so 3 Thread will execute simultaneously.
		
		ExecutorService executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

		
		//Created Runnable array with define 6 task to be executed.
		MyRunnable21[]  runnable = {new MyRunnable21("Rahul"),
				new MyRunnable21("Mendiratta"),
				new MyRunnable21("Sumit"),
				new MyRunnable21("Prasad"),
				new MyRunnable21("test"),
				new MyRunnable21("Test1234")};

		for(MyRunnable21 run : runnable) {

			executor.submit(run);
			

		}

		executor.shutdown();


	}

}
