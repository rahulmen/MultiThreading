package com.learning.Arrays;

/*
Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
Output: true
There is a pair (6, 10) with sum 16
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayComponentWithDefinedSum {

    static List<Combination> list = new ArrayList<Combination>();

    public static class Combination{
        int a;
        int b;

        Combination(int a,int b){
            this.a=a;
            this.b=b;
        }

    }

    public static void findPair(int[] arr,int sum){

        for(int i=0;i<arr.length;i++){
            int sum1=0;
            for(int j=i;j<arr.length;j++){
                sum1=arr[i]+arr[j];
                if(sum1==sum){
                    list.add(new ArrayComponentWithDefinedSum.Combination(arr[i],arr[j]));
                }
            }
        } }

    public static void main(String[] args){

        int[] arr = new int[]{21,3,5,7,12,15,18,1};
        int sum = 22;
        findPair(arr,22);
        Iterator<Combination> itr = list.iterator();
        while(itr.hasNext()){
            Combination combination = itr.next();
            System.out.println(combination.a+" "+combination.b);
        }
    }

}


