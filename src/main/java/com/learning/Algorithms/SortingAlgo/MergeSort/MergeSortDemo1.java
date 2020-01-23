package com.learning.Algorithms.SortingAlgo.MergeSort;

public class MergeSortDemo1 {

        /*
        MergeSort(arr[], l,  r)
        If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
         */


        public static int[] mergeSort(int[] arr,int begin,int end){

            if(begin<end){
                int mid = begin+(end-1)/2;
                return mergeSort(arr,begin,mid);
            }

            return null;
        }

        public static int[] merge(int[] arr,int begin,int middle,int end){


            return null;

        }

        public static int[] MergeSort(int[] arr,int beginIndex,int endIndex){

                if(beginIndex<endIndex) {
                    int mid = beginIndex+(endIndex-1)/2;
                    arr = mergeSort(arr,0,mid);
                    arr = mergeSort(arr,mid+1,endIndex);
                    arr = merge(arr,beginIndex,mid,endIndex);
                }
            return arr;
        }

        public static void main(String[] args){


            int[] arr = {12,11,13,5,6,7};
            MergeSort(arr,0,arr.length-1);



    }


}
