package com.learning.Algorithms.SearchingAlgo.TernarySearching;

public class TernarySearchDemo1 {

    public int ternarySearch(int[] arr,int begin,int end,int search){

        int middle1= begin+(end-begin)/3;
        int middle2= end-(end-begin)/3;

        if(end>=0) {

            if (search == arr[middle1]) {
                return middle1;
            }
            else if (search == arr[middle2]) {
                return middle2;
            }
            else if(search<arr[middle1]){
                return ternarySearch(arr,begin,middle1-1,search);
            }
            else if(search>arr[middle2]) {
                return ternarySearch(arr,middle2+1,end,search);
            }
            else{
                return ternarySearch(arr,middle1+1,middle2-1,search);
            }

        }
        return -1;
    }


    public static void main(String... args){

        int[] arr = {3,5,8,12,18,43,49,65,69,89,90};
        TernarySearchDemo1 ternarySearchDemo1 = new TernarySearchDemo1();
        int index = ternarySearchDemo1.ternarySearch(arr,0,arr.length-1,90);
        System.out.println(index);

    }


}
