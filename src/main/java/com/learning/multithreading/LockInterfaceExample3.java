package com.learning.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
 * This Program demostrate how we use tryLock with wait so that both thread will get a chance to execute. 
 * 
 */



class MyThread22 extends Thread{
	
	
	static ReentrantLock lock = new ReentrantLock();
	
	MyThread22(){
		super();
	}
	
	public void run() {
		
		do {
		try {
			if(lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
				System.out.println(Thread.currentThread().getName() + " got a chance and started Execution");
				try {
					Thread.sleep(30000);
				}catch(InterruptedException e) {
					e.getMessage();
				}
				lock.unlock();
				break;
			}else {
				System.out.println(Thread.currentThread().getName() + " didnt get a chance to start Exection");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(true);
		
		
	}
	
	
}


public class LockInterfaceExample3{
	
	
	public static void main(String[] args) {
		
	MyThread22 t1 =	new MyThread22();
	t1.setName("First thread");
	MyThread22 t2 =	new MyThread22();
	t2.setName("Second Thread");
	t1.start();
	t2.start();
	}
	
	
}