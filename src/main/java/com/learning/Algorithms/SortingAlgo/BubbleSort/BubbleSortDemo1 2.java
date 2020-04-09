package com.learning.Algorithms.SortingAlgo.BubbleSort;

public class BubbleSortDemo1 {

    public static void main(String... args){

        int[] arr = new int[]{56,23,87,42,98,67,45,99};

        for(int i=arr.length-1;i>=1;i--){
            for(int j=0;j<i-1;j++){

                if(arr[j]>arr[j+1]){
                    //Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }
        }

        for(int arr1:arr){
            System.out.print(arr1+" ");
        }


    }

}
