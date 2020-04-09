package com.learning.Algorithms.Practice;

/*
* Like Binary search for ternary search also out array need to be sorted.
 */

public class TernarySearch {

    public static int[] arr = new int[]{23, 25, 34, 36, 38, 43, 47, 56, 58, 67, 69, 78, 79, 89, 90, 93, 96, 97};

/*
* method that will perform ternary search
 */

    public int ternarySearch(int startindex,int maxlength,int find){


        if(maxlength>=1){

            int ave1 = startindex+(maxlength-startindex)/3;
            int ave2= maxlength-(maxlength-startindex)/3;

            if(arr[ave1]==find)
                return ave1;
            if(arr[ave2]==find)
                return ave2;
            if(find<arr[ave1])
                return ternarySearch(1,ave1-1,find);
            else if(find>arr[ave2])
              return ternarySearch(ave2+1,maxlength,find);
            else
               return ternarySearch(ave1+1,ave2-1,find);
        }
        return -1;
    }

    public static void main(String[] args){

        System.out.print(new TernarySearch().ternarySearch(1,arr.length-1,78));



    }


}
