package com.learning.InterviewPreparation.CollectionAndMapFrameWork;


import java.util.Comparator;
import java.util.TreeMap;
import java.util.logging.Logger;

class MyComparator5 implements Comparator {

    private static Logger logger = Logger.getLogger(String.valueOf(MyComparator5.class));

    public int compare(Object obj1,Object obj2){

        Integer itr1 = (Integer)obj1;
        Integer itr2 = (Integer)obj2;

        /*if(itr1>itr2){
            return +1;
        }else{
            return -1;
        }*/

        return itr1.compareTo(itr1);
    }
        }

public class TreeMapDemo2 {

    private static Logger logger = Logger.getLogger(String.valueOf(MyComparator5.class));

    public static void main(String... args){

        TreeMap<Object,Object> treeMap = new TreeMap<Object,Object>(new MyComparator5());
        treeMap.put(1,"test01");
        treeMap.put(23,"test02");
        treeMap.put(22,"test03");
        treeMap.put(24,"test04");

    }

}
