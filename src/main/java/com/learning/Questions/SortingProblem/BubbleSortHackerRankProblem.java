package com.learning.Questions.SortingProblem;

import java.util.Arrays;

public class BubbleSortHackerRankProblem {

    static class Result{
        int numberOfSwaps;
        int[] sortedArray;
        int firstElement;
        int lastElement;

        Result(int swaps,int[] sortedArray,int firstElement,int lastElement){
            this.numberOfSwaps=swaps;
            this.sortedArray=sortedArray;
            this.firstElement=firstElement;
            this.lastElement=lastElement;
        }

        public int getNumberOfSwaps() {
            return numberOfSwaps;
        }

        public int[] getSortedArray() {
            return sortedArray;
        }

        public int getFirstElement() {
            return firstElement;
        }

        public int getLastElement() {
            return lastElement;
        }
    }


    public static Result binarySort(int[] arr){

        int swap=0;
        int firstElement=0;
        int lastElement=0;
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(j==arr.length-1){
                    break;
                }
                if(arr[j]>arr[j+1]){
                    swap++;
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        firstElement= arr[0];
        lastElement=arr[arr.length-1];
        return new Result(swap,arr,firstElement,lastElement);

    }



    public static void main(String... args){

        int[] arr = {4,2,3,1};
        Result result = binarySort(arr);

        System.out.print("Number of Swaps : " + result.getNumberOfSwaps()+"\n"+"The Sorted Array is : "+ Arrays.toString(result.getSortedArray())+"\n"+
                "The First Element in an Array : "+result.getFirstElement()+"\n"+"The Last Element in an Array : "+result.getLastElement());

    }

}
