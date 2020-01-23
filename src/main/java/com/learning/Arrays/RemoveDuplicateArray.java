package com.learning.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicateArray {

    public int[] removeDuplicate(Integer[] arr){

        int[] temp = new int[arr.length];

        Arrays.sort(arr);

        int begin = 0;
        for(int i=0;i<arr.length-1;i++){
           if(arr[i]==arr[i+1]){
               continue;
           }else {
               temp[begin] = arr[i];
               begin++;
               temp[begin]=arr[i+1];
           }
       }

        return temp;
    }

    public static void main(String... args){

        Integer[] arr = {1,4,3,6,5,4,3,7,8,9};

        System.out.print(Arrays.toString(new RemoveDuplicateArray().removeDuplicate(arr)));

    }
}
