package com.learning.Arrays;

/*
Input : arr[] = {12, 10, 5, 6, 52, 36}
            k = 2
Output : arr[] = {5, 6, 52, 36, 12, 10}
Explanation : Split from index 2 and first
part {12, 10} add to the end .

Input : arr[] = {3, 1, 2}
           k = 1
Output : arr[] = {1, 2, 3}
Explanation : Split from index 1 and first
part add to the end.
 */

import org.testng.annotations.Test;

public class SplitArrayAddFirstPartToEnd {

    public void splitArrayByIndex(int[] arr,int index){
        int localIndex=index;
        if(index>=arr.length-1){
            throw new RuntimeException("Array Split index ");
        }
        while(localIndex<=arr.length-1){
            System.out.print(arr[localIndex]+" ");
            localIndex++;
        }
        localIndex=0;
        while(index>localIndex){
            System.out.print(arr[localIndex]+" ");
            localIndex++;
        }
    }

    @Test
    public void test(){
        SplitArrayAddFirstPartToEnd splitArrayAddFirstPartToEnd = new SplitArrayAddFirstPartToEnd();
        int[] arr = {12, 10, 5, 6, 52, 36};
        splitArrayAddFirstPartToEnd.splitArrayByIndex(arr,2);


    }

}
