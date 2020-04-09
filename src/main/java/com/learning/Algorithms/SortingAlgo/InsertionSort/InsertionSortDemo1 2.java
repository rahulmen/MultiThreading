package com.learning.Algorithms.SortingAlgo.InsertionSort;

/*
* In insertion sort we perform shifting Operation not swapping where as in Selection and Bubble Sort we perform Swapping operation.
 */

import java.util.Arrays;

public class InsertionSortDemo1 {

    // 4 1 5 3 2
    // 1 4 5 3 2
    // 1 4 5 3 2    // 1 3 5 3 2
    // 1 3 4 5 2
    // 1 2 3 4 5

    public static void main(String... args){

        int[] arr = {4,1,5,3,2};
        int[] temp = arr;

        for(int i=0;i<temp.length;i++) {

            int index = 0;
            int value = arr[i];

            for (int j = 0; j < i; j++) {
                if (temp[i] < temp[j]) {
                    //Shifting the element
                    index = j;// at index value i have to shift arr[i] and move remaining element one element ahead
                    // at jth index i have to insert temp[i]

                    for (int k = i; k > index; k--) {
                        temp[k] = temp[k - 1];
                    }

                    temp[index] = value;

                }
            }
        }

        System.out.print(Arrays.toString(temp));

    }


}
