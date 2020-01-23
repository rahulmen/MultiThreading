package com.learning.Algorithms.SortingAlgo.MergeSort;

import java.util.Arrays;

/* Java program for Merge Sort */
public class MergeSort {


    public static void merge(int[] arr,int begin,int mid,int end){

        int[] localarr = new int[end-begin+1];
        int i=begin,j=mid+1;

        for(int k=0;k<localarr.length;k++){
            if(i<=mid && j<=end && arr[i]>arr[j]){
                localarr[k]=arr[j];
                j++;
            }else if(j<=end && i<=mid && arr[j]>arr[i]){
                localarr[k]=arr[i];
                i++;
            }else if(i>mid){
                localarr[k]=arr[j];
                j++;
            }else{
                localarr[k]=arr[i];
                i++;
            }
        }

        int a = 0;
        while(a<localarr.length){
            arr[begin+a]=localarr[a];
            a++;
        }
    }

    public static int[] mergeSort(int[] arr,int left,int right){

        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
        return arr;

    }


    public static void main(String[] args){

        int[] arr = {43,78,32,1234,8765,237,98765,28765,24567,8765,23765,765,345};

        arr = mergeSort(arr,0,arr.length-1);

        System.out.print(Arrays.toString(arr));



    }


}