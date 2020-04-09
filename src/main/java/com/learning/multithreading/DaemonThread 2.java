package com.learning.multithreading;

public class DaemonThread extends Thread{
	
	public void run() {
		System.out.println(Thread.currentThread().isDaemon());
	}

	public static void main(String[] args) throws InterruptedException {
		
		DaemonThread t = new DaemonThread();
		
		System.out.println(Thread.currentThread().isDaemon());
		t.setDaemon(true);
		Thread.sleep(5000);
		t.start();
		
	}
	
}
