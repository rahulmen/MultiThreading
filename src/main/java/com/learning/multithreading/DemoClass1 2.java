package com.learning.multithreading;

public class DemoClass1 extends Thread 
{
    public static void main(String [] args) 
    {
    	DemoClass1 t = new DemoClass1();
        t.start();
        System.out.print("one. ");
        t.start();
        System.out.print("two. ");
    }
    public void run() 
    {
        System.out.print("Thread ");
    }
}