
/*
 * Program to demonstrate how sybchronized method can only be accessed by single thread at a time to avoid DataInconsistency Issue.
 */

package com.learning.multithreading;


class Display1{

	public void displayc(String name) {
		//1 lack line of code
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
		//Instead of making complete method as synchronized we have to make particular block as synchronized
		//So performance of the system should should not decrease.
		synchronized(this) {
			for(int i =0;i<=10;i++) {
				System.out.print("Good Morning :");
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name);
			}}
	}
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	//1 lack lines of code

}
//-----------------------------------------------

class MyRunnbale6 implements Runnable {
	Display1 d;
	String name;

	/*
	 * Constructor to initialize Greeting class reference and name
	 */
	MyRunnbale6(Display1 d,String name){
		this.d=d;
		this.name=name;
	}

	public void run() {
		d.displayc(name);
	}
}
//-------------------------------------------------------
class TestClass10{

	public static void main(String[] args) {
		Display1 d = new Display1(); 
		Runnable r = new MyRunnbale6(d,"Dhoni");
		Thread t1 = new Thread(r);
		Runnable r1 = new MyRunnbale6(d,"Yuvraj");
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	}

}


