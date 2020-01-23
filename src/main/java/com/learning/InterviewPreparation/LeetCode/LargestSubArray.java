package com.learning.InterviewPreparation.LeetCode;

import java.util.Arrays;

public class LargestSubArray {

    public int maxSubArray(int[] nums) {

        int initial = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>initial){
                initial=nums[i];
            }
        }

        for(int i=0;i<nums.length-1;i++){
          for(int j=1;j<nums.length;j++){
              while(i<j){
                  int localSum=0;

              }
          }

        }

        return initial;
    }

    public static void main(String... args){


        int sum = new LargestSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});

        System.out.println(sum);

    }
}
