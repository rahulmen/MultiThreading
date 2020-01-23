package com.learning.Algorithms.SortingAlgo.MergeSort;

import org.testng.annotations.Test;

import java.util.Arrays;

public class MergeSortFinalSolution {


    public void merge(int[] arr,int begin,int mid,int end){

        int[] localArray = new int[end-begin+1];

        int i = begin;
        int j = mid+1;

        for(int k=0;k<localArray.length;k++){

            if(i<=mid && j<=end && arr[i]<arr[j]){
                localArray[k]=arr[i];
                i++;
            }else if(i<=mid && j<=end && arr[j]< arr[i]){
                localArray[k]=arr[j];
                j++;
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





    @Test
    public void sort(){

        int[] arr = {5,3,6,8,1,2,4};

        arr = mergeSort(arr,0,arr.length-1);

        System.out.print(Arrays.toString(arr));


    }


}
