package com.learning.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterfaceExample1 {
	
	public static void main(String[] args) {
		
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.lock();
		System.out.println(lock.getHoldCount());  //2 as Main thread has 2 lock count.
		System.out.println(lock.getQueueLength()); //0 as no other thread is waiting for lock of current object
		//System.out.println(lock.hashCode());
		lock.unlock();
		System.out.println(lock.isHeldByCurrentThread());//true as main thread still have lock of current thread
		System.out.println(lock.getHoldCount()); //1
		lock.unlock();
		System.out.println(lock.getHoldCount()); //0
		System.out.println(lock.isHeldByCurrentThread()); //false as main thread no longer contains lock of ReentrantLock 
		
	}

}
