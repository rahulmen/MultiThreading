package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

import java.util.HashMap;
import java.util.WeakHashMap;

class Temp extends Object{

    @Override
    public String toString(){
        return "temp";
    }

    @Override
    public void finalize(){
        System.out.print("Finalise method call");
    }





    }


public class WeakHashMapDemo1 {

    public static void main(String... args){

        WeakHashMap weakHashMap = new WeakHashMap();
        HashMap hashMap = new HashMap();
        Temp p = new Temp();
        //weakHashMap.put(p,"Weak Temp Object 1");
        hashMap.put(p,"Non Weak Temp Object 1");
        //System.out.println(weakHashMap);
        System.out.println(hashMap);
        p=null;
        System.gc();
        //System.out.println(weakHashMap);
        System.out.println(hashMap);

    }


}
