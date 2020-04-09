package com.learning.multithreading;

class InterThread {
	
	synchronized public void m1() {
		System.out.println("This is a Synchronized block");	
	}

}



class InterThreadCommunication extends Thread{
	
	
	public void run() {
		
		
		for(int i=0;i<10;i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		InterThreadCommunication t = new InterThreadCommunication();
		t.start();
		InterThread obj = new InterThread();
		
	}
	
	
}
