package com.learning.CoreJava;

public class InterfaceCallingClass1{

     int x = 10;

     public static void main(String... args){

          Interface1 inteface1 = new ImplementingClass2();
          Interface1 inteface2= inteface1.name();
          inteface1.surname();



     }

}
