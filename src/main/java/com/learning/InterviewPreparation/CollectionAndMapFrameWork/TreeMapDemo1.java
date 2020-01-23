package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

/*
* Map element are inserted as per the hashCode of keys.
*
 */

import java.util.TreeMap;

public class TreeMapDemo1 {

    public static void main(String... args){

        //Using default natural sorting technique
        TreeMap<Object,Object> treeMap = new TreeMap<Object,Object>();

        treeMap.put(1,"Rahul0");
        treeMap.put(2,"Rahul1");
        treeMap.put(10,"Rahul2");
        treeMap.put(12,"Rahul3");

        System.out.print(treeMap);


    }

}
