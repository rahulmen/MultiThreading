package com.learning.multithreading.EnhancedMultiThreading;

/*
* There are many advantage of use java.lang.concurrent.lock package instead of using synchronised keyword to achieve Thread safety.
*
*
* 1. Synchronised Keyword can only be used at method level or inside method but it can not be used within two methods but we can use
*    .lock() method and .unlock() between two methods as well.
*
* Example :- public synchronised void m1(){};  //valid
*            public void m1(){
*            //some line of code
*             synchronised{}
*              //some line of code
*               }  //valid
*
 */

import java.util.concurrent.locks.ReentrantLock;

public class LockVsSyncronised {

    public static void main(String[] args){

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.lock();
        System.out.println(reentrantLock.isLocked());
        System.out.println(reentrantLock.getHoldCount());
        reentrantLock.unlock();
        System.out.print(reentrantLock.getHoldCount());
        reentrantLock.unlock();
        System.out.println(reentrantLock.getHoldCount());
        System.out.println(reentrantLock.isLocked());

    }


}
