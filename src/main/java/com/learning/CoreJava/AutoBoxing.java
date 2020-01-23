package com.learning.CoreJava;

public class AutoBoxing {


    public static void main(String... args){

        Integer i1 = 10;
        Integer i2 = 10;

        System.out.println(i1==i2);
        System.out.println(i1.equals(i2));

        Integer i3 = new Integer(30);
        Integer i4 = new Integer(30);

        System.out.println(i3==i4);
        System.out.println(i3.equals(i4));

        int i5 = i1;
        System.out.print(i5);

        Integer i6 = i5;
        System.out.print(i6);

    }


}
