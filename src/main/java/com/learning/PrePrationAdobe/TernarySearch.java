package com.learning.PrePrationAdobe;

public class TernarySearch {

    public int ternarySearch(int[] arr,int begin,int end,int searchBit) {

        if (end >= 0) {

            int mid1 = begin + (end - begin) / 3;
            int mid2 = end - (end - begin) / 3;

            if (searchBit == arr[mid1]) {
                return mid1;
            } else if (searchBit == arr[mid2]) {
                return mid2;
            } else if (searchBit < arr[mid1]) {
                return ternarySearch(arr, begin, mid1 - 1, searchBit);
            } else if (searchBit > arr[mid2]) {
                return ternarySearch(arr, mid2 + 1, end, searchBit);
            } else {
                return ternarySearch(arr, mid1 + 1, mid2 - 1, searchBit);
            }
        }
        return -1;
    }



    public static void main(String... args){

        int[] arr = {1,4,7,12,15,18,34,38,45,77,89};

        int index = new TernarySearch().ternarySearch(arr,0,arr.length-1,45);

        System.out.println(index);
    }


}
