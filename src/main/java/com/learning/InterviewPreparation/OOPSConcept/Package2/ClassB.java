package com.learning.InterviewPreparation.OOPSConcept.Package2;

import com.learning.InterviewPreparation.OOPSConcept.Package1.ClassA;

import static java.lang.System.out;

public class ClassB extends ClassA {

    public  static  void  main(String... args){


        ClassA classA = new ClassA();
        ClassA classA1 = new ClassB();
        ClassB classB = new ClassB();

        //Protected member can only be accesed outside package using child reference.

        out.print(classB.a);



    }

}
