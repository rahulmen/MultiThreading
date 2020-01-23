package com.learning.Deleted;




public class TestClass2 {

public static void main(String... args){

    Object o = new String("ABC");

    // A b = (C)D;

    // C and D must have some relation either parent to child or child tot parent.
    // A and C must be either same or derived Type
    String s = (String)o;
    System.out.println(o);
    System.out.println(s);


    Long l = new Long(10);
    Long i = (Long)l;


}



}






