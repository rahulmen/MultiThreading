package com.learning.PrePrationAdobe;

import java.util.Arrays;

public class MergeSort2 {


    public void merge(int[] arr,int begin,int mid,int end){

        int[] localArray = new int[end-begin+1];

        int i=begin;
        int j= mid+1;


        for(int k=0;k<localArray.length;k++){
            if(i<=begin && j<=end && arr[i]>arr[j]){
                localArray[k]=arr[j];
                j++;
            }else if(i<=begin && j<=end && arr[j]>arr[i]){
                localArray[k]=arr[i];
                i++;
            }else if (i>mid){
                localArray[k]=arr[j];
                j++;
            }else{
                localArray[k]=arr[i];
                i++;
            }
        }


        for(int l=0;l<localArray.length;l++){
            arr[begin+l]=localArray[l];
        }

    }


    public int[] mergeSort(int[] arr,int begin,int end){

        if(begin<end){
            int mid = (begin+end)/2;
            mergeSort(arr,begin,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,begin,mid,end);


        }

return arr;
    }

    public static void main(String... args){

        int[] arr = {34,53,132,543,1432,543,654321,6543,12334};

        int[] array = new MergeSort2().mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(array));

    }


}
