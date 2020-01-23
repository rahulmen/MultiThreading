package com.learning.CoreJava;

public class ImplAbstractClass1 extends AbstractClass1{

    int i;
    ImplAbstractClass1(){
        this.i=20;
    }

    @Override
    public void m1(){
        System.out.print(this.i + " " +super.i);
    }

    public static void main(String... args){

        ImplAbstractClass1 implAbstractClass1 = new ImplAbstractClass1();
        implAbstractClass1.m1();
    }
}
