/*
 * This class demonstrate Thread Priority
 */

package com.learning.multithreading;


class ExceptionHandling extends Exception{

	public ExceptionHandling(String e){
		System.out.println("Thread is Interrpted" + e);

	}

}

class MyThread61  implements Runnable  {


	public void run(){

		for(int i =0;i<10;i++){
			System.out.println("Child1 Thread");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}

}



public class TestClass6 {



	public static void main(String[] args) throws ExceptionHandling{

		MyThread61 t1 = new MyThread61();
		Thread t2 = new Thread(t1);
		t2.start();
		try{
			
			t2.join();
			
		}catch(InterruptedException e){
			
			throw new ExceptionHandling(e.getMessage());
		}
		
	for(int i =0;i<10;i++)
	{
		System.out.println("Main Thread");
		Thread.yield(); //Here we have applied yield method on main thread
	}
	//Thread.sle

}

}

