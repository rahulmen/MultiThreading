/*
 * Programn to demonstare how many active thread and thread group System thread group have 
 */

package com.learning.multithreading;

public class SystemThreadGroup {
	
	public static void main(String[] args) {
		
	ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
	
	//This will tell number of active Thread present in System ThreadGroup
	Thread[] t = new Thread[system.activeCount()];
	
	//Copies into the specified array every active thread in this thread group and its subgroups.An invocation of this method behaves in exactly the same way as the invocation 

	system.enumerate(t);
	
	for(Thread t1 :t) {
		System.out.println(t1.getName() + "-------" + t1.isDaemon());
	}
			
		
	}

}


/*
Output :-
Reference Handler-------true
Finalizer-------true
Signal Dispatcher-------true
Attach Listener-------true
main-------false
*/