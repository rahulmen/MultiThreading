/*
* 1. ThreadGroup is the class in Java which is the direct child class of Object.
* 2. ThreadGroup can have many threads and can also have many sub ThreadGroup.
* 3. System is the parent group of all the ThreadGroup in Java.
* 4. We use threadGroup if we want to manage group of threads as a same unit.
 */


package com.learning.multithreading.EnhancedMultiThreading;

import java.lang.ThreadGroup;

public class ThreadGroupCreation {


    public static void main(String[] args){

        //Creation of ThreadGroup

        System.out.println("Top Level Parent Thread :"+Thread.currentThread().getThreadGroup().getParent().getName()); //system is the parent of main thread group
        System.out.println("Main Thread :"+Thread.currentThread().getName());
        //This proves system is the parent of all thread group

        ThreadGroup g1 = new ThreadGroup("First Thread Group");
        System.out.println(g1.getName());
        System.out.println(g1.getParent().getName()); //main is the parent of First Thread Group
        System.out.println(g1.getMaxPriority());

        //Create another sub ThreadGroup of First ThreadGroup

        ThreadGroup g2 = new ThreadGroup(g1,"Second Thread Group");
        System.out.println(g2.getName());
        System.out.println(g2.getParent().getName()); //Here
        System.out.println(g2.getMaxPriority());

        //Defining two thread in sub thread group Second Thread Group`
        Thread t1 = new Thread(g2,"Second ThreadGrooup First Thread");
        Thread t2 = new Thread(g2,"Second ThreadGroup Second Thread");

        //Defining one thread in sub thread group First Thread Group`
        Thread t3 = new Thread (g1,"First ThreadGroup Third Thread");


        g1.list(); //First Thread Group Information
        System.out.println("======");
        g2.list(); //Second Thread Group information

        Thread[] t = new Thread[3];
        int threadCount= g1.enumerate(t);

        ThreadGroup[] threadGroups = new ThreadGroup[3];
        int threadGroup = g1.enumerate(threadGroups);

        System.out.print("Number of Thread in First Group :"+threadCount+"\n"+"Number of ThreadGroup in First Group :"+threadGroup);

        threadCount= g2.enumerate(t);
        threadGroup=g2.enumerate(threadGroups);

        System.out.print("\n"+"Number of Thread in Second Group :"+threadCount+"\n"+"Number of ThreadGroup in Second Group :"+threadGroup);













    }


}
