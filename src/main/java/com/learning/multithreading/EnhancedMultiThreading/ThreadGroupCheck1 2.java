package com.learning.multithreading.EnhancedMultiThreading;

class MyThread1 extends Thread{

     MyThread1(ThreadGroup threadGroup,String threadName){
        super(threadGroup,threadName);
    }

    @Override
    public void run(){

         System.out.println("Thread Executing : "+ Thread.currentThread().getName());

         try {
             Thread.sleep(5000);
         }catch(InterruptedException nsee){
             nsee.printStackTrace();
         }
         }

}

public class ThreadGroupCheck1 {

    public static void main(String[] args) throws InterruptedException{

        ThreadGroup threadGroup = new ThreadGroup("First thread Group");

        Thread thread1 = new MyThread1(threadGroup,"First Thread");
        Thread thread2 = new MyThread1(threadGroup,"Second Thread");

        thread1.start();thread2.start();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        int count = threadGroup.enumerate(threads);

        System.out.print("Number of Active Thread in threadGroup : "+count+"\n");

        Thread.sleep(10000);

        System.out.print("Getting number of thread in System ThreadGroup");

        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] thread = new Thread[system.activeCount()];
        system.enumerate(thread);

        for(Thread thread3:thread){
            System.out.println(thread3.getName()+"----"+thread3.isDaemon());
        }




    }


}
