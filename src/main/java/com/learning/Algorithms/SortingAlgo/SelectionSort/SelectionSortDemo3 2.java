package com.learning.Algorithms.SortingAlgo.SelectionSort;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SelectionSortDemo3 {


    @Test
    public void selectionSort(){

        int[] arr = {3,1,6,4,1,8,7,9};

        for(int i=0;i<arr.length-1;i++){

            int min = arr[i];
            int index = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<min){
                    min = arr[j];
                    index = j;
                }
            }
            //perform swapping
            int temp = arr[i];
            arr[i]=min;
            arr[index]=temp;

        }

        System.out.print(Arrays.toString(arr));

    }

}
