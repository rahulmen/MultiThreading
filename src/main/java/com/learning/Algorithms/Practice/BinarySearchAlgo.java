/*
* Binary Search only work on a Sorted Collection or array.
 */

package com.learning.Algorithms.Practice;

public class BinarySearchAlgo {

     static int[] arr = new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};

     public static int binarySearch(int min,int max,int key){

         while(min<=max){
             int average = (min+max)/2;

             if(arr[average]<key){
                 min=average+1;
             }
             else if(arr[average]>key){
                 max = average-1;
             }
             else{
                 return average;
             }
         }
         return -1;   //Key Not Found
     }

     public static void main(String... args){

         int index = binarySearch(0,arr.length-1,65);
         System.out.println(index);




     }

}
