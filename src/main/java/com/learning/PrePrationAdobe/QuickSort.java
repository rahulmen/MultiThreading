package com.learning.PrePrationAdobe;

import java.util.Arrays;

public class QuickSort {

    public int partition(int[] arr,int low,int high){

        int pivot = arr[high];

        int i = low-1;

        for(int j=low;j<high;j++){

            if(arr[j]<pivot){
                //Swap Logic
                i++;

                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }



        }

        int temp = arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;

    }



    public void sort(int[] arr,int low,int high){

        if(low<high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    public static void main(String[] args){


        int[] arr = {5,3,8,4,2,8,1,0};

        new QuickSort().sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));





    }


}
