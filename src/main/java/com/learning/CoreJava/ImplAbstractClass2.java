package com.learning.CoreJava;

public class ImplAbstractClass2 {

    int i;

    ImplAbstractClass2(){
        this.i=10;
    }

    public AbstractClass1 m1(){
        return new AbstractClass1(){
            @Override
            void m1() {
                System.out.print(this.i+" "+super.i);
            }
        };
    }


    public static void main(String... args){

        ImplAbstractClass2 implAbstractClass2 = new ImplAbstractClass2();
        AbstractClass1 abstractClass1 = implAbstractClass2.m1();
        System.out.println(abstractClass1.i);



    }

}
