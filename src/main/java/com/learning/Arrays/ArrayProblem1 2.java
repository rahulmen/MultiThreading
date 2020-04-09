package com.learning.Arrays;

/*
*   Write a program to check whether two given Arrays are equal, given both contains same data type and same length ?
 */

public class ArrayProblem1 {

    public static void compareArray(int[] arr1,int arr2[]) {
        boolean output = true;
        l1:
        for (int i = 0; i < arr1.length; i++) {
            l2:
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] != arr2[j] && j != arr2.length - 1) {
                    continue l2;
                } else if (arr1[i] != arr2[j] && j == arr2.length - 1) {
                    output=false;
                    break;
                }
                else if (arr1[i] == arr2[j]) {
                    continue l1;
                }
            }
        }
        if(output==false) {
            throw new RuntimeException("Array are not similar");
        }else{
         System.out.println("Array are Similar");
        }

    }

    public static void main(String... args){

        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{2,1,3,5,4};

        compareArray(arr1,arr2);





    }

}
