package com.learning.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class DisplayNameName{


	/*
	 * Instead of using synchronized keyword to restrict thread to single access to this method we can also use ReentrantLock lock object
	 */
	ReentrantLock lock = new ReentrantLock();
	public void wish(String name) {
		
		lock.lock(); //Use lock() method to get lock of current Object so only one Thread can access this method at a time and remaining thread will wait for this thread to call unlock method
		System.out.print("Good Morning :");
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(name);
		lock.unlock();
	}

}


class Mythread11 extends Thread{

	DisplayNameName d;
	String name;

	Mythread11(DisplayNameName d,String name){
		this.name=name;
		this.d=d;
	}

	public void run() {

		d.wish(name);
	}

}


public class LockInterfaceExample2 {

	static DisplayNameName d = new DisplayNameName();

	public static void main(String[] args) {


		Mythread11 t1 = new Mythread11(d,"Dhoni");
		Mythread11 t2 = new Mythread11(d, "Yuvraj");
		Mythread11 t3 = new Mythread11(d, "Kholi");
		t1.start();
		t2.start();
		t3.start();

	}



}
