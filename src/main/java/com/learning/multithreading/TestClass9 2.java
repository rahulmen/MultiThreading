
/*
 * Program to demonstrate how sybchronized method can only be accessed by single thread at a time to avoid DataInconsistency Issue.
 */

package com.learning.multithreading;


class Display{

	synchronized public void displayn() {
		for(int i =0;i<=10;i++) {
			System.out.print(i);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}}}
		
	synchronized public void displayc() {
		for(int i =65;i<=75;i++) {
			System.out.print((char)i);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}}}
	
}
//-----------------------------------------------

	class MyRunnbale4 implements Runnable {
		Display d;

		/*
		 * Constructor to initialize Greeting class reference and name
		 */
		MyRunnbale4(Display d){
			this.d=d;
		}
		
		public void run() {
			d.displayc();
		}
	}
	
	class MyRunnbale5 implements Runnable {
		Display d;

		/*
		 * Constructor to initialize Greeting class reference and name
		 */
		MyRunnbale5(Display d){
			this.d=d;
		}
		
		public void run() {
			d.displayn();
		}
	}
//-------------------------------------------------------
	class TestClass9{
		
		public static void main(String[] args) {
		Display d = new Display(); 
		Runnable r = new MyRunnbale4(d);
		Thread t1 = new Thread(r);
		Runnable r1 = new MyRunnbale5(d);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
		}
		
	}
	
	
