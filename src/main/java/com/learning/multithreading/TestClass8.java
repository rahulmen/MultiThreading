
/*
 * Program to demonstrate how sybchronized method can only be accessed by single thread at a time to avoid DataInconsistency Issue.
 */

package com.learning.multithreading;


class Greeting	{

	synchronized public void wish(String name) {
		for(int i =0;i<=10;i++) {
			System.out.print("Good Morning :");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
		
	}
}
//-----------------------------------------------

	class MyRunnbale3 implements Runnable {
		Greeting g;
		String name;
		/*
		 * Constructor to initialize Greeting class reference and name
		 */
		MyRunnbale3(Greeting g,String name){
			this.g=g;
			this.name=name;
		}
		
		public void run() {
			g.wish(name);
		}
	}


//-------------------------------------------------------
	class TestClass8{
		
		public static void main(String[] args) {
		Greeting g = new Greeting(); 
		Runnable r = new MyRunnbale3(g,"Dhoni");
		Thread t1 = new Thread(r);
		t1.start();
		Runnable r1 = new MyRunnbale3(g,"Yuvraj");
		Thread t2 = new Thread(r1);
		t2.start();
		
		}
		
	}
	
	
