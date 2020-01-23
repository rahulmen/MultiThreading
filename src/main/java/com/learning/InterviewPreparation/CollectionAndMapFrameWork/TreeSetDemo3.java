package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator2 implements Comparator {

    @Override
    public int compare(Object obj1,Object obj2){
        String str1 = (String)obj1;
        String str2 = (String)obj2;

        int length1 = str1.length();
        int length2 = str2.length();

        if(length1>length2){
            return +1;
        }else if(length1<length2){
            return -1;
        }else{
            return 0;
        }
        /*
        Another Way
        return -str1.compareTo(str2);
         */


    }

}

public class TreeSetDemo3 {

    public static void main(String... args){


        TreeSet<Object> treeSet = new TreeSet<Object>(new MyComparator2());
        treeSet.add("ABC");
        treeSet.add("A");
        treeSet.add("ABCD");
        treeSet.add("ABCDE");
        treeSet.add("AB");



        System.out.print(treeSet);




    }
}
