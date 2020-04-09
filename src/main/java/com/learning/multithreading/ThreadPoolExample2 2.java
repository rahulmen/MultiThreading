/*
 * This program demostrate how to find sum of first n number using thread pool
 */

package com.learning.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyRunnbale22 implements Callable{

	int num;

	public MyRunnbale22(int num) {
		this.num=num;	
	}

	public Object call() throws Exception{
		int sum=0;
		for(int i=1;i<=num;i++) {
			sum = sum+i;
		}
		System.out.print(Thread.currentThread().getName() + " starts Execution and sum of first " + num + " number is "  );
		
		Thread.sleep(1000);
		
		return sum;

	}

}

//------------------------------------------------

public class ThreadPoolExample2 {

	public static void main(String[] args) throws Exception{

		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		
		MyRunnbale22[] runnable= {new MyRunnbale22(10),new MyRunnbale22(20),new MyRunnbale22(30),new MyRunnbale22(40),new MyRunnbale22(50),new MyRunnbale22(60),new MyRunnbale22(70),new MyRunnbale22(80)
									,new MyRunnbale22(90),new MyRunnbale22(100)};

		for(MyRunnbale22 run : runnable) {
			Future f = executor.submit(run);
			System.out.print(f.get());
			System.out.println();
		}

		executor.shutdown();



	}

}
