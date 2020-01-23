package com.learning.Algorithms.Practice;

/*
 *Selection sort is based on the idea of finding the mimimum and maximum element in an unsorted array and then putting them
 * in the correct position in the Sorted array.
 *
 *Assume that the array  needs to be sorted in ascending order.
 *
 * The minimum element in the array i.e.  is searched for and then swapped with the element that is currently located at the first position, i.e. . Now the minimum element in the remaining unsorted array is searched for and put in the second position, and so on.

 * Time Complexity:
 *
 * 1. To find the min element from an array of Size N and N-1 comparison is required.
 * 2. Then size of the array will be reduce to N-1 and N-2 comparison is required until Size of array will be 2 and 1 comparison is required.
 *
 * (N-1)+(N-2)+(N-3)+1= N(N-1)/2 == O(n^2)
 *
 */

public class SelectionSort {

    public static int[] selectionSort(int[] arr){
        int[] arr1 = arr;
        int minimun;
        for(int i=0;i<arr.length-1;i++){
        minimun=i;
        for(int j=i;j<arr.length;j++){
            if(arr[j]<arr[minimun]){
                minimun=j;
            }
        }
            //swap minimum
            int temp = arr[i];
            arr[i] = arr[minimun];
            arr[minimun]=temp;
        }
    return arr1;
    }


    public static void main(String[] args){

        int[] arr = new int[]{12,32,43,12,42,65,34,54,23,53};
        int[] arr1 = selectionSort(arr);

        for(int arr2:arr1){
            System.out.print(arr2+" ");
        }


    }

}
