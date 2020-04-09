package com.learning.Algorithms.SearchingAlgo.BinarySearch;

public class BinarySearchDemo1 {

    public int binarySearch(int[] arr,int initial,int end,int searchBit){


        int[] arr1 = arr;

        if(end>=initial) {
            int mid = (initial+end)/2;
            if (arr[mid] == searchBit) {
                return mid;
            }
            else if(searchBit>arr[mid]){
             return  binarySearch( arr1,mid+1,end,searchBit);

            }
            else if(searchBit<arr[mid]) {
                return binarySearch(arr1, initial, mid - 1, searchBit);

            }
        }
        return -1;
    }



    public static void main(String... args){

        BinarySearchDemo1 binarySearchDemo1 = new BinarySearchDemo1();
        int[] arr = {2,4,7,9,23,28,54,78,89,99};
        int index = binarySearchDemo1.binarySearch(arr,0,arr.length-1,54);
        System.out.println("SearchBit is present on index :"+index);


    }
}
