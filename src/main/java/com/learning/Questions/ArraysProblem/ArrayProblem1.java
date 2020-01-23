package com.learning.Questions.ArraysProblem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayProblem1 {

    /*
        * Given an array arr have to find the number of number od count
     */


    public static int getCount(int[] arr,int count){

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int arr1:arr){

            if(map.containsKey(arr1)){
                map.put(arr1,map.get(arr1)+1);
            }else if(!map.containsKey(arr1)){
                map.put(arr1,1);
            }
        }

        Set set = map.entrySet();
        Iterator itr = set.iterator();

        while(itr.hasNext()){

            Map.Entry entry = (Map.Entry)itr.next();
            if(entry.getValue().equals(count)){
                return (Integer)entry.getKey();
            }

        }
        return -1;
    }

    public static void main(String[] args){

        int[] arr = {1,4,2,3,4,5,2,3,4,5,6,7,3,2,1};

        System.out.println(getCount(arr,4));




    }

}
