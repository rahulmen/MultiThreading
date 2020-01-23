package com.learning.Arrays;

/*
* Program to find all pair whose sum is an odd number.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayPairSumOdd {

    public static class Pair{
        int a;
        int b;

        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }

    public List<Pair> getCombinations(int[] arr){
        List<Pair> pair = new ArrayList<Pair>();

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if((arr[i]+arr[j])%2==1){
                    pair.add(new ArrayPairSumOdd.Pair(arr[i],arr[j]));
                }
            }
        }

        return pair;
    }

    public static void main(String... args){

        ArrayPairSumOdd arrayPairSumOdd = new ArrayPairSumOdd();

        int[] arr = {1,4,6,3,5,2,7,8};

        Iterator<Pair> iterator = arrayPairSumOdd.getCombinations(arr).iterator();

        while(iterator.hasNext()){
            Pair temp = iterator.next();
            System.out.println(temp.a + " " + temp.b);

        }






    }

}
