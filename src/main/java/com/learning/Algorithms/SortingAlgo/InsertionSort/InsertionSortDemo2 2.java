package com.learning.Algorithms.SortingAlgo.InsertionSort;

/*
1.Insertion Sort is similar to arranging a deck of card in your hand.
2.You will check second to last cards and place it into the write position
3. As card is inserted in between we have to shift all other cards by one index.
 */

import java.util.Arrays;

public class InsertionSortDemo2 {


    public static void main(String... args){

        int[] arr = {4,1,7,9,8,3};

        l1:
        for(int i=1;i<arr.length;i++){
            int number = arr[i];
            l2:
            for(int j=0;j<i;j++){


                if(arr[j]>arr[i]){

                    int index = j;
                    int local = i;

                    while(local>j){
                        arr[local]=arr[local-1];
                        local--;
                    }

                    arr[index]=number;
                }
            }
        }


        System.out.print(Arrays.toString(arr));



    }

}
