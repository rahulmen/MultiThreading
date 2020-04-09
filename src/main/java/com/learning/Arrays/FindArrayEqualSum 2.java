package com.learning.Arrays;

/*
* This program is used to return index whose left and right index sum is equal
 */

public class FindArrayEqualSum {


    static int[] arr = new int[]{3,2,5,4,2,3,5};

    public static int getIndexUsingNormalWay(){
        int firstHalfsum=0;
        int secondHalfSum=0;

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                firstHalfsum=firstHalfsum+arr[j];
            }
            for(int j=i+1;j<arr.length;j++){
                secondHalfSum=secondHalfSum+arr[j];
            }
            if(firstHalfsum==secondHalfSum){
                return i;
            }else{
                firstHalfsum=0;
                secondHalfSum=0;
            }
        }
        return -1;
    }

    public static int getIndexUsingWay2(){
        int frontSum=0;
        int BackSum=0;

        for(int i=0;i<arr.length;i++){
            frontSum = frontSum + arr[i];
            BackSum = BackSum + arr[i];
        }

        for(int i=0;i<arr.length;i++){
            frontSum=frontSum-arr[i];
            if (i == 0) {
                BackSum=BackSum-arr[arr.length-1];
            }else{
                BackSum=BackSum-arr[arr.length-1-i];
            }

            if(frontSum==BackSum) {
                return i+1;
            }else{
                continue;
            }

        }
        return -1;
    }



    public static void main(String[] args){
        System.out.print("Index "+getIndexUsingNormalWay()+"\n"+"Value "+arr[getIndexUsingNormalWay()]);
        System.out.print("\n"+"Index "+getIndexUsingWay2()+"\n"+"Value "+arr[getIndexUsingWay2()]);



    }
}
