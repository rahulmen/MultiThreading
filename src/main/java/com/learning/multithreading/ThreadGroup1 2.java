/*
 * Program to demonstrate Thread group and method to get thread group name
 */

package com.learning.multithreading;

public class ThreadGroup1 {

	public static void main(String... args) {

		System.out.println(Thread.currentThread().getName()); //main as this line is executed by main thread
		System.out.println(Thread.currentThread().getThreadGroup().getName());//main as main thread belong to main thread group
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());//system as main thread group belong to System ThreadGroup

		//Creating ThreadGroup
		ThreadGroup g = new ThreadGroup("First Group");

		System.out.println(g.getParent().getName());//As this line is executed my main thread then this ThreadGroup belongs to main ThreadGroup.

		//Creating another ThreadGroup inside ThreadGroup.

		ThreadGroup g1 = new ThreadGroup(g,"SecongGroup");
		
		System.out.println(g1.getParent().getName());//FirstGroup
		
		//System-------MainGroup------FirstGroup-----SecondGroup
		
		System.out.println(g.getMaxPriority()); //Default max priorty of ThreadGroup is 10
		
		Thread t1 = new Thread(g,"First Thread");
		Thread t2 = new Thread(g,"Secong Thread");
		
		g.setMaxPriority(3);

		Thread t3 = new Thread(g,"ThirdThread");
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		
		/*
		 * 
		 * Threads in the ThreadGroup that have already higher priority wont be effective but for newly added Thread this max priority is applicable
		 * 
		 */
		
		
	}

}
