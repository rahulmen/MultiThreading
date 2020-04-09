package com.learning.Arrays;

/*
* Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
 */

public class ArrayReversalAlgo {

    static int arr[];


    public static void rotate(int[] arr,int size){

        //Logic find

        int mid = (size+1)/2;

        for(int i=0;i<=mid;i++){
               int temp =  arr[i];
               arr[i]=arr[size-i];
               arr[size-i] = temp;
            }
            }


    public static void main(String[] args) {

        arr = new int[]{2, 4, 2, 4, 2, 5, 53, 2, 3, 1, 23, 89, 78};
        rotate(arr, arr.length-1);

        for (int arr1 : arr) {
            System.out.print(arr1 + " ");


        }

    }}
