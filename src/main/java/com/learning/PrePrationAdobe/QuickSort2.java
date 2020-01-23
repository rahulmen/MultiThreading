package com.learning.PrePrationAdobe;

import java.util.Arrays;

public class QuickSort2 {


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

    public void sort(int[] arr,int low,int high){

        if(low<high){
            int partition = partition(arr,low,high);
            sort(arr,low,partition-1);
            sort(arr,partition+1,high);
        }

    }


    public static void main(String... args){


        int[] arr = {8,2,4,9,23,12,68};

        new QuickSort2().sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));


    }




}
