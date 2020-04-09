package com.learning.Algorithms.SortingAlgo.BubbleSort;

/*
Worst case Time complexity of Bubble Sort is O(n^2)
Best Case time complexity of Bubble Sort is O(n)

 */

public class BubbleSortDemo2 {

    public static void main(String[] args){

        int[] arr = {23,24,245,25543,5323,6432,75432,34565,26787654,12345,65,432,4565432,2345766,2,3576543,2365432,676543};

       // int[] arr = {3,5,1,7,9,5};

        int length = arr.length;

        while(length>=1){

            int flag = 0;
            for(int i=0;i<length-1;i++){

                if(arr[i]>arr[i+1]){
                    //Swap Both Element
                    int temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
            if(flag==0){
                break;
            }
            length--;
        }


        for(int arr2:arr){
            System.out.print(arr2+",");
        }



    }


}
