

/*
 * Program to demostrate teh behaviour of deadlock dute to synchronized keyword.
 */

package com.learning.multithreading;

 class DeadlockA {
	
	synchronized public void m1(DeadlockB b) {
		System.out.println("Thread A starts Execution");
		try {
			Thread.sleep(6000);
		}catch(InterruptedException e) {
			
		}
		b.end();
	}
	
	synchronized public void end() {
		System.out.println("ThreadB waiting for threadA to relase lock of This class");
		
	}

}

 class DeadlockB {
	
	 synchronized public void m1(DeadlockA a) {
		System.out.println("Thread B starts execution");
		try {
			Thread.sleep(6000);
		}catch(InterruptedException e) {
			
		}
		a.end();
	}
	
	 synchronized public void end() {
		System.out.println("ThreadA waiting for threadB to relase lock of This class");
	}

}


public class DeadlockC extends Thread{

	DeadlockA obj = new DeadlockA();
	DeadlockB obj1 = new DeadlockB();
	
	public void execute() {
		this.start();//this means object of class DeadLockC so child thread will be started and run() method will be executed.

		obj.m1(obj1);
		
	}
	
	public void run() {
		obj1.m1(obj);//Child thread will contains lock of obj1
		
		
	}
	
	public static void main(String[] args) {
		
		DeadlockC obj = new DeadlockC();
		/*
		 * Will call {@link execute} method
		 * 
		 */
		obj.execute(); 
		
		
		
		
		
	}
	
	
}