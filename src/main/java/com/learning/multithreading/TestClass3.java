/*
 * This class demonstrate Thread Priority
 */

package com.learning.multithreading;


class RuunbaleThread implements Runnable{

	public void run(){


		System.out.println(Thread.currentThread().getName()); //Child-0
		System.out.println(Thread.currentThread().getPriority()); // Priority is 10


		for(int i =0;i<10;i++){
			System.out.println("Child Thread");
		}
	}

}

public class TestClass3 {


	public static void main(String[] args){

		RuunbaleThread r1 = new RuunbaleThread();
		Thread t = new Thread(r1); //Creating Child Thread
		t.setPriority(10); //Setting Child Thread Priority to 10
		t.start(); //Starting Child Thread
		
		System.out.println(Thread.currentThread().getName());  //Main Thread
		System.out.println(Thread.currentThread().getPriority()); //Default Priority is 5
		
		
		//t.start(); //This will throw Illegal ThreadStateException
		for(int i =0;i<10;i++)
		{
			System.out.println("Main Thread");
		}

	}

}

/*
 * As Priority of Child Thread is Set to 10 So Child Thread run() method will be Executed First and then main thread will be executed
*/