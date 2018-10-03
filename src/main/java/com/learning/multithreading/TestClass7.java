
/*
 * Program to demonstrate how main child thread wait for main thread as child thread dont have main thread object
 */

package com.learning.multithreading;




class MyThread71  extends Thread  {


public static Thread t3;
	
	public void run(){
		
		try {
			t3.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i =0;i<10;i++){
			System.out.println("Child1 Thread");
			
		}

	}

}



public class TestClass7 {



	public static void main(String[] args) throws ExceptionHandling{

		MyThread71 t1 = new MyThread71();
		
		
		MyThread71.t3= Thread.currentThread();
		
		t1.start();
		
		
	for(int i =0;i<10;i++)
	{
		
		System.out.println("Main Thread");
		try{
			Thread.currentThread().sleep(2000);
		}catch(InterruptedException e){
			throw new ExceptionHandling(e.getMessage());
		}
		
	}

	
}

}

