package com.learning.CoreJava;

public class ImplementingClass2 implements  Interface1{

     public Interface1 name(){
          System.out.println("Name is Tarun");
          return new ImplementingClass2();
     }

     public void surname(){
          System.out.println("Surname is Papneja");
     }

}
