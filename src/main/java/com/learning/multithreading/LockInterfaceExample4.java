/*
 * This program demonstrate how we can use trylock() method of lock interface so that even if thread 2 didn't get a lock it will perform alternative operation and will not wait for Thread lock.
 */


package com.learning.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class MyThread21  extends Thread{


	MyThread21(String name){
		super(name);
	}

	static  ReentrantLock lock = new ReentrantLock(); //Define it static to make it class level and for every thread only single copy will be created.

	public void run() {
		if(lock.tryLock()) { 
			System.out.println( Thread.currentThread().getName() +  " got the lock and begin execution"); //Will print thread name which got the lock with execution message.
			try {
				Thread.sleep(2000); //Thread 
			}catch(InterruptedException e) {
				e.getMessage();
			}
			lock.unlock();
		}
		else {
			System.out.println(Thread.currentThread().getName() + " has not got the lock and performing alternative opearion"); //Will print thread name which didnt got the lock with execution message.
		}
	}

}

public class LockInterfaceExample4 {

	public static void main(String[] args) {

		MyThread21 t1 = new MyThread21("First Thread");
		MyThread21 t2 = new MyThread21("Second Thread");
		t1.start();
		t2.start();

	}

}




