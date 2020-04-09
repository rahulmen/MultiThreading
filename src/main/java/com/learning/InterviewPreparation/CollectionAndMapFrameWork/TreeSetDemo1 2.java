package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

/*
 If we use default constructor of TreeSet then elements are added as per the default natural Sorting Order
 that is for Integer it is in Increasing Order
 For String it is in alphabetic Order.

 If we are using default natural Sorting then the object type need to be homogenous.
 If we will use hetrogenous then we will get ClassCaste Exception.

 StringBuffer do not contain compareTo Method thats why we need to Convert StringBuffer to String before performing
 user defined Sorting.

 */


import java.util.TreeSet;

public class TreeSetDemo1{

    public static void main(String... args){

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(15);
        treeSet.add(20);
        treeSet.add(0);
        treeSet.add(5);
        treeSet.add(10);

        System.out.println(treeSet);

        TreeSet<Object> treeSet1 = new TreeSet<Object>();

        treeSet1.add("a");
        treeSet1.add("c");
        treeSet1.add("G");
        treeSet1.add("C");
        treeSet1.add("ABC");
        //treeSet1.add(new StringBuffer("ABC"));

        System.out.println(treeSet1);



    }

}
