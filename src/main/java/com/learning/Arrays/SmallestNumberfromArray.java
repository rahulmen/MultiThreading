package com.learning.Arrays;

/*
Approach :-

We will sort the array using Insertion Sort
then we will remove duplicates
return the array the Kth number is the number we want
 */

import java.util.Arrays;

public class SmallestNumberfromArray {

    public  static int[] sortArray(int[] arr){

        for(int i=1;i<arr.length;i++){

            int number = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>number){
                arr[j+1]=arr[j];
                j=j-1;
            }

            arr[j+1]=number;
        }
            return arr;
    }

    public static int[] removeDuplicate(int[] arr){
        int[] temp = new int[arr.length];
        int count=0;

        for(int i=0;i<arr.length;i++){
            if(i==0){
                temp[count]=arr[i];
                count++;
            }else if(arr[i]==temp[count-1]){
                continue;
            }else {
                temp[count]=arr[i];
                count++;
            }
        }

        int temp1[] = new int[count];
        for(int i=0;i<count;i++){
            temp1[i]=temp[i];
        }
        return temp1;
    }


    public static void main(String... args){


        int[] arr= {4,8,6,4,8,3,4,5,6,7,5,4,9,8,7};

        arr = sortArray(arr);
        System.out.print(Arrays.toString(arr));

        arr = removeDuplicate(arr);
        System.out.print(Arrays.toString(arr));





    }

}
