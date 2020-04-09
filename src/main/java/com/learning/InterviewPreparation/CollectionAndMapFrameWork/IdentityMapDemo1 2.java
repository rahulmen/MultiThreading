package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

import java.util.IdentityHashMap;

public class IdentityMapDemo1 {


    public static void main(String... args){

        IdentityHashMap identityHashMap = new IdentityHashMap();
        Integer integer = new Integer(1);
        Integer integer1 = new Integer(1);
        identityHashMap.put(1,"test01");
        identityHashMap.put(2,"test02");
        identityHashMap.put(1,"test03");
        /*
        * If we want to add Entry in map with same key then we should use IdentityHashMap
        * Because in normal HashMap while entering keys we use .equals() method that is meant
        * for content comparison
        *
        * But in Identity HashMap keys are enter using == which is meant for reference Comparison.
        *
         */
        identityHashMap.put(integer,"test04");
        identityHashMap.put(integer1,"test05");
        System.out.print(identityHashMap);


    }

}
