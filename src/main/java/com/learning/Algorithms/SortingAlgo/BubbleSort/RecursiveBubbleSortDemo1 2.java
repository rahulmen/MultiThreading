package com.learning.Algorithms.SortingAlgo.BubbleSort;

import java.util.Arrays;

public class RecursiveBubbleSortDemo1 {

    private static void bubbleSort(int[] arr,int length){

        if(length==1){
            return;
        }

        for(int i=0;i<length-1;i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }

        bubbleSort(arr,length-1);

    }

    public static void main(String... args){

        int[] arr = {2,5,9,7,5,799,334,999,1000,1007};

        //int[] arr = {4};


        bubbleSort(arr,arr.length);

        System.out.print(Arrays.toString(arr));


    }


}
