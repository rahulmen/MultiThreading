package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

/*
 If we use default constructor of TreeSet then elements are added as per the default natural Sorting Order
 that is for Integer it is in Increasing Order
 For String it is in alphabetic Order.

 If we are using default natural Sorting then the object type need to be homogenous.
 If we will use hetrogenous then we will get ClassCaste Exception.

 */


import java.util.Comparator;
import java.util.TreeSet;

class MyComparator1 implements Comparator {

    @Override
    public int compare(Object obj1,Object obj2){

        Integer i1 = (Integer)obj1;
        Integer i2 = (Integer)obj2;

        if(i1>i2){
            return -1;
        }else if(i1<i2){
            return +1;
        }else{
            return 0;
        }

       /*
       * Another Way :-
        return -i1.compareTo(i2);
        */
    }
}

public class TreeSetDemo2 {

    public static void main(String... args){

        TreeSet<Integer> treeSet = new TreeSet<Integer>(new MyComparator1());
        treeSet.add(15);
        treeSet.add(20);
        treeSet.add(0);
        treeSet.add(5);
        treeSet.add(10);

        System.out.print(treeSet);



    }

}
