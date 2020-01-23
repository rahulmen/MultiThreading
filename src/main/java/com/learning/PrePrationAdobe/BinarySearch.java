package com.learning.PrePrationAdobe;

public class BinarySearch {

    public int binarySearch(int[] arr1,int begin,int end,int searchBit){

        int[] arr = arr1;

        if(end>=begin){

            int mid = (end+begin)/2;

            if(arr[mid]==searchBit){
                return mid;
            }
            else if (arr[mid]<searchBit){
                return binarySearch(arr,mid+1,end,searchBit);
            }else{
                return binarySearch(arr,0,mid-1,searchBit);
            }
        }

        return -1;

    }



    public static void main(String[] args){

        int[] arr = {1,4,7,12,15,18,34,38,45,77,89};

        int index = new BinarySearch().binarySearch(arr,0,arr.length-1,34);

        System.out.println(index);


    }

}
