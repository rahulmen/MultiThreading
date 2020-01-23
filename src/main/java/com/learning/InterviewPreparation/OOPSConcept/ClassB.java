package com.learning.InterviewPreparation.OOPSConcept;

public class ClassB extends ClassA implements Runnable{

    public static void main(String[] args){

        ClassA obj = new ClassB();
        Runnable r = new ClassB();
        System.out.print(obj instanceof ClassA);
        System.out.print(obj instanceof ClassB);

        System.out.print(r instanceof ClassB);




    }

    @Override
    public void run() {

    }
}
