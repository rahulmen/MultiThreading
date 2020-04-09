package com.learning.InterviewPreparation.DesignPattern.SingletonDemo1;

public class Test {


    public static void main(String... args){

        SingletonDemo1 singletonDemo1 = SingletonDemo1.getInstance();
        System.out.print(singletonDemo1.getI());
        SingletonDemo1 singletonDemo2 = SingletonDemo1.getInstance();

        if(singletonDemo1==singletonDemo2){
            System.out.print("Singelton Acheived");
        }else{
            System.out.print("Singelton Not Acheived");
        }


    }
}
