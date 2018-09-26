/*
 * This class demonstrate Thread Priority
 */

package com.learning.multithreading;


class RuunbaleThread1 implements Runnable{

	public void run(){




		for(int i =0;i<10;i++){
			System.out.println("Child Thread");





		}

	}

}

public class TestClass4 {


	public static void main(String[] args){

		RuunbaleThread1 r1 = new RuunbaleThread1();
		Thread t = new Thread(r1); //Creating Child Thread
		t.start();


		for(int i =0;i<10;i++)
		{
			System.out.println("Main Thread");
			Thread.yield(); //Here we have applied yield method on main thread
		}

	}

}

