package com.learning.PrePrationAdobe.AdobeQuetions;

/*
Sort array with only 0's 1's and 2's
 */


import java.util.Arrays;

public class Problem3 {


    public int partition(int[] arr,int low,int high){

        int pivot = arr[high];
        int i = low-1;


        for(int j=low;j<high;j++){

            if(arr[j]<pivot){
                i++;

                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;

            }
        }

        int temp = arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;

    }


    public int[] sort(int[] arr,int low,int high){

        if(low<high){
            int partition = partition(arr,low,high);
            sort(arr,low,partition-1);
            sort(arr,partition+1,high);
        }

        return arr;
    }

    public static void main(String... args){

        int[] arr = {1,2,2,2,1,1,0,0,1,2,1,0,2,0,2,0};

        int[] array = new Problem3().sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(array));



    }

}
