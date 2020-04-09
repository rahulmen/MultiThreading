/*
 * This class demonstrate Thread Priority
 */

package com.learning.multithreading;


class MyThread51 extends Thread {
	public void run(){
		for(int i =0;i<10;i++){
			System.out.println("Child1 Thread");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
				}}}}

class MyThread52 extends Thread {
	
	public void run(){
		
		for(int i =0;i<10;i++){
			System.out.println("Child2 Thread");
		}}}

public class TestClass5 {

	public static void main(String[] args){

		MyThread51 t1 = new MyThread51();
		t1.start();
		//Here we have 2 Thread main thread and Child Threa.Child Thread is responsible to execute overrided  run() method defined in MyThread5 class.
		
		MyThread52 t2 = new MyThread52();
		t2.start();
		
		try{
		t1.join(); //This line is executed by Main thread so main thread will wait until CHild Thread will be completed.
		//Above Line menas main thread will wait for unlimited amount of time until child thread will be completed
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		for(int i =0;i<10;i++)
		{
			System.out.println("Main Thread");
			Thread.yield(); //Here we have applied yield method on main thread
		}

	}

}

