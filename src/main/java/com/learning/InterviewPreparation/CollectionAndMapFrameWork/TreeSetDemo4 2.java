package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator3 implements Comparator{

    @Override
    public int compare(Object obj1,Object obj2){

        String str1 = obj1.toString();
        String str2 = obj2.toString();

        return str1.compareTo(str2);

    }

}

public class TreeSetDemo4 {

    public static void main(String[] args){

        TreeSet<Object> treeSet = new TreeSet<>(new MyComparator3());
        treeSet.add("ABC");
        treeSet.add("AB");
        treeSet.add(new StringBuffer("A"));
        treeSet.add("A");
        treeSet.add(1);
        System.out.print(treeSet);
    }
}
