package com.learning.Algorithms.SearchingAlgo.LinearSearch;

/*
You are given a list of n-1 integers and these integers are in the range of 1 to n.
There are no duplicates in the list. One of the integers is missing in the list.
Write an efficient code to find the missing integer.

Input: arr[] = {1, 2, 4,, 6, 3, 7, 8}
Output: 5

Input: arr[] = {1, 2, 3, 5}
Output: 4

 */

public class FindMissingNumber {

    static int[] arr = {0,1,2,3,4,6,5,7,9};

    public static void main(String[] args){
        int arrLength = arr.length;
        //int missingNum=0;

        int sum = arrLength*(arrLength+1)/2;

        for(int i=0;i<arr.length;i++){
            sum=sum-arr[i];
        }

        System.out.print(sum);


    }



}
