package com.learning.Algorithms.Practice;

/*
* Difference Between BubbleSort and SelectionSort
*
* 1. In bubble sort we compare adjacent element and mimimum element will be placed at the first index.
* 2. And for each element we have to iterate complete array so time complexity is O(n^2)
*
*
* 1. In Selection sort we find the minimum element in one array iteration and replace it from the starting iteration index of an array
* 2. Time Complexity is also O(n^2) as for each element we have to iterate the array to find
*
* Assumption :- Consider the first element as an minimum element and compare all other element
* with the min element and find the min and replace it from the first index.
*
 */

public class SortingExample {

    private static int[] bubbleSort(int[] arr1){

        for(int i=0;i< arr1.length;i++){
            for(int j=i;j<arr1.length-i-1;j++){
                if(arr1[j]<arr1[i]){
                    int temp = arr1[i];
                    arr1[i]=arr1[j];
                    arr1[j]=temp;
                }
            }
        }
            return arr1;
    }

    private static int[] selectionSort(int[] arr) {
        int minimum;
        for (int i = 0; i < arr.length - 1; i++) {
            minimum=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minimum]) {
                    minimum = j;  //set index j as minimum based on condition
                }
            }
            //swap minimum
            int temp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum]=temp;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr1 = new int[]{23,12,42,23,543,5532,11224,5533,22332,22322,23,432454};
        int arr[] = selectionSort(arr1);
        int arr2[] = bubbleSort(arr1);

        System.out.print("Using Selection Sort : ");
        for(int arr3:arr){
            System.out.print(arr3+" ");
        }
        System.out.println();

        System.out.print("Using Bubble Sort : ");

        for(int arr4:arr){
            System.out.print(arr4+" ");

        }

    }

}
