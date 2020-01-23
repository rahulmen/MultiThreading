package com.learning.PrePrationAdobe;

import java.util.Arrays;

public class SelectionSort {



    public static void main(String... args){


        int[] arr = {7,3,9,5,8,3,5,1,10};


        for(int i=0;i<arr.length-1;i++){

            int minIndex = i;

            for(int j=i;j<arr.length;j++){

                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }

            }

            //Write Swap Logic


           int temp = arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;

        }

        System.out.println(Arrays.toString(arr));

    }


}
