package com.learning.Algorithms.SortingAlgo.SelectionSort;

public class SelectionSortDemo1 {

    public static void main(String[] args){

        int[] arr = {3,1,2,5,4};


        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //Write Swap Program here
            if(arr[i]!=arr[minIndex]){
            int temp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        }

        for(int arr1:arr){
            System.out.print(arr1+" ");
        }

    }

}
