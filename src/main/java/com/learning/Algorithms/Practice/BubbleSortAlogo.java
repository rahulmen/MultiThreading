/*
*Program to demonstrate bubbleSort on an array
* Time complexity of bubble sort is O(n^2)
* In bubble sort we iterate the complete array for each element of an array
 */


package com.learning.Algorithms.Practice;

import org.testng.annotations.Test;

public class BubbleSortAlogo {

    private static int count;

    private int[] bubbleSortAscending(int[] arr){
        for (int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                int temp;
                if(arr[j]>arr[j+1]){
                   temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
                   count++;
                }
            }
        }
        return arr;
    }


    @Test
    public void bubbleSortTest(){
        int[] arr = new int[]{12,42,123,532,4421,455,11,76543,233135,65432,76543};
        arr = bubbleSortAscending(arr);

        for(int arr1:arr){
            System.out.print(arr1+" ");
        }
        System.out.println("");
        System.out.print("Number of Iteration to sort passed array "+count);
    }

}
