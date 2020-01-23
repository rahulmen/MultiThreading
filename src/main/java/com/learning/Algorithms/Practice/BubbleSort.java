package com.learning.Algorithms.Practice;

public class BubbleSort {

    public static int arr[] = new int[]{32,45,99,22,77};

    /*
    *Bullle Search Method time complexity is O(n^2) as for each element we have to iterate over complete array
    * Sort in ascending order
     */

    public static int[] bubbleSort(int[] array,int length){
        int temp;

    for(int i=0;i<length-1;i++) { //We have to iterate complete array every Time
        for (int j = 0; j <length-i-1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return array;
    }




    public static void main(String[] args){
      arr = bubbleSort(arr,arr.length);

      for(int arr1:arr){
          System.out.print(arr1+" ");
      }



    }

}
