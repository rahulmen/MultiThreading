package com.learning.multithreading;

public class InterThreadCom {


	public static void main(String[] args) throws InterruptedException {

		MyThreadB t = new MyThreadB();
		System.out.println("Main Thread start Execution");
		t.start();
		//@Thread.sleep(10000); 
		/*
		 * Using Thread.sleep() is not best approach because run() method will only take nanoseconds to execute so why to hault over execution for more time
		 * Overrall performance of the system will be reduced.
		 */
		
		//@t.join();
		/*
		 * Here main thread is calling join method on Mythread this approach is also not good because if we have 1 lack lines in run() method then our script will
		 * have to wait until all lack line of code execution is complete.Hence the best approach is to use wait() notify() method
		 * 
		 */
		
		/*
		 * Now when we will call t.wait() so main thread will move into waiting state and will let child thread to execute run() method and notify back when done
		 *  
		 */
		synchronized(t) {
		t.wait();
		}
		System.out.print("Main thread displaying count:");
		System.out.println(t.count);

	}


}



class MyThreadB extends Thread{

	int count=0;

	public void run() {
		System.out.println("Child thread start executing run() method");
		synchronized(this) {
			for(int i=1;i<=100;i++) {
				count = count+i;
			}
			System.out.println("Child Thread notifying main thread");
			this.notify();
		
		}
	}





}
