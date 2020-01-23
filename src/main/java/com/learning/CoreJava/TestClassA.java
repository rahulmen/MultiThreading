package com.learning.CoreJava;

public class TestClassA {

    final int a=10;
    static int b;

    public void m1(){
        int i=10;
        i=20;
        System.out.print(i);
    }

    public static void main(String[] args){

        TestClassA testClass = new TestClassA();
        //System.out.print(testClass.a);
        System.out.print(testClass.a+" "+b);





    }

}
