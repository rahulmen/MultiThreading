package com.learning.Arrays;

/*
Input  : arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}
Output : arr[] = {1, 2, 3, 4, 5}
         new size = 5
 */

import java.util.Arrays;

public class RemoveDuplicatesFromArray {

    public static int[] removeDuplicates(int[] arr){

        int temp[] = new int[arr.length];
        int count = 0;

        for(int i=0;i<arr.length;i++){

            if(i==0){

                temp[count]=arr[i];
                count++;

            }else if(arr[i]==temp[count-1]){
                        continue;
            }else{
                temp[count]=arr[i];
                count++;
            }
            }

        return temp;
    }


    public static void main(String[] args){

        int[] arr = {0,0,1, 2, 2, 3, 4, 4, 4, 5, 5};

        System.out.print("Arrays after removing Duplicate : "+ Arrays.toString(removeDuplicates(arr)));


    }



}
