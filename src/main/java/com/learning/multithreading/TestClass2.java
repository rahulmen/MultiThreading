package com.learning.multithreading;



class MyRunnbale implements Runnable{
	
public void run(){
		
		/*
		 * To set and get Current thread name
		 */
		Thread.currentThread().setName("Rahul Mendiratta Thread");
		System.out.println(Thread.currentThread().getName());
		for(int i =0;i<10;i++){
			System.out.println("Child Thread");
		}
	}
	
}

public class TestClass2 {
	
	
	public static void main(String[] args){		
/*
 * MyRunnbale Class Dont have any start() method and also its child class Runnable also dont have any start() 
 * method so we have to create object of Thread class * and pass reference of MyRunnbale class as an argument so that Thread class start() method should start the Child Thread.
* Actually Runnbale Interface dont have the capability to start the Thread.
 */
		Runnable r = new MyRunnbale();
		Thread t = new Thread(r);
		t.start();
		System.out.println(Thread.currentThread().getName());
		
		for(int i =0;i<10;i++)
		{
			System.out.println("Main Thread");
		}
		
	}

}
