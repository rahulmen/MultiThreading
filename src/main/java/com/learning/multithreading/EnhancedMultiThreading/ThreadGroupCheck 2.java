package com.learning.multithreading.EnhancedMultiThreading;

class MyThread implements Runnable{


    @Override
    public void run(){

        System.out.println("Run Method executed by thread:"+ Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch(InterruptedException nsee){
            nsee.printStackTrace();
        }
    }
}

public class ThreadGroupCheck {

    public static void main(String[] args) throws Exception{


        ThreadGroup threadGroup = new ThreadGroup("First Group");

        Runnable runnable1 = new MyThread();
        Thread thread1 = new Thread(threadGroup,runnable1);
        thread1.setName("Thread-0 in "+threadGroup.getName());

        Runnable runnable2 = new MyThread();
        Thread thread2 = new Thread(threadGroup,runnable2);
        thread2.setName("Thread-1 in "+threadGroup.getName());

        thread1.start();
        thread2.start();

        //Count Number of Thread in threadGroup {First Group}

        Thread[] threads = new Thread[3];
        int count = threadGroup.enumerate(threads);

        System.out.print("\n"+"Number of active Thread in "+threadGroup.getName()+" : "+count);

        Thread.sleep(10000);

        count = threadGroup.enumerate(threads);
        System.out.print("\n"+"Number of active Thread in "+threadGroup.getName()+" : "+count);





    }
}
