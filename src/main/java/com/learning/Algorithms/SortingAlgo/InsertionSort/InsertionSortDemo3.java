package com.learning.Algorithms.SortingAlgo.InsertionSort;

/*
1.Insertion Sort is similar to arranging a deck of card in your hand.
2.You will check second to last cards and place it into the write position
3. As card is inserted in between we have to shift all other cards by one index.
 */

import java.util.Arrays;

public class InsertionSortDemo3 {


    public static void main(String... args){

        int[] arr = {4,1,1,7,9,8,3};


        for(int i=1;i<arr.length;i++){

            int number = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>number){
                arr[j+1]=arr[j];
                j--;
            }

            arr[j+1]=number;
        }
    System.out.print(Arrays.toString(arr)+"\n");


    }


}
