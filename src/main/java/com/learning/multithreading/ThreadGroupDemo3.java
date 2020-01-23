/*
 * Program demonstrate use of void list() method to print number of active Thread and ThreadGroup in current ThreadGroup.
 */

package com.learning.multithreading;

class MyThreadExample extends Thread{
	
	MyThreadExample(ThreadGroup g,String name){
		super(g,name);
	}
	
	public void run() {
		System.out.println("Child Thread");
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e ) {
			e.printStackTrace();
		}
	}
}

public class ThreadGroupDemo3 {
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadGroup g1 = new ThreadGroup("First Group"); //Created ThreadGroup with name First Group and reference g1
	
		ThreadGroup g2 = new ThreadGroup(g1,"Second Group"); ////Created sub ThreadGroup with name Second Group in ThreadGroup First Group 
		
		MyThreadExample t1 = new MyThreadExample(g1, "First Thread"); //Created Thread inside FirstThreadGroup named First thread.
		MyThreadExample t2 = new MyThreadExample(g1, "Second Thread"); //Created Thread inside FirstThreadGroup named Second Thread.
		MyThreadExample t3 = new MyThreadExample(g2, "Third Thread"); //Created Thread inside SecondThreadGroup named Third Thread.
		t1.start(); //Started Thread run() method will be Executed
		t2.start(); //Started Thread run() method will be Executed
		t3.start();
		System.out.println(g1.activeCount()); //Will tell us number of active thread in FirstGroup
		System.out.println(g1.activeGroupCount()); //Will tell us number of active threadGroup in FirstGroup
		g1.list(); //Display Thread related information on console.
		
		Thread.sleep(10000); //As Thread is moved into Sleeping meanwhile run() method will be completed and Thread will move into dead() state.
		System.out.println("=====================================================");
		System.out.println(g1.activeCount()); // No Active Thread remained
		System.out.println(g1.activeGroupCount()); // But ThreadGroup is still active with no Thread in it
		g1.list();
		
		/*
		System-------main-----FirstGroup-------t1
						|			|
						|			|
					SecondGroup		t2
						|
						|
						t3
	
	*/
	
	
	}
	
}
