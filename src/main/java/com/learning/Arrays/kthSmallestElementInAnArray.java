package com.learning.Arrays;

import java.util.Arrays;

public class kthSmallestElementInAnArray {


    public static int[] min(int[] arr,int k){

        if(k>arr.length){
            throw new RuntimeException("Array Length is smaller than max index asked");
        }
        int[] localArray = new int[k];

        for(int i=1;i<arr.length;i++){

            int number = arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>number){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=number;
        }

        for(int i=0;i<localArray.length;i++){
            localArray[i]=arr[i];
        }


        return localArray;
    }


    public static void main(String[] args){

        int[] arr = {34,12,67,45,98,78,99,654,89};

        System.out.print(Arrays.toString(min(arr,5)));

    }

}
