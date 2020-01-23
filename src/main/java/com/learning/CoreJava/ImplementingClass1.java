package com.learning.CoreJava;

public class ImplementingClass1 implements  Interface1{

     public Interface1 name(){
          System.out.println("Name is Rahul");
          return new ImplementingClass1();
     }

     public void surname(){
          System.out.println("Surname is Mendiratta");
     }

}
