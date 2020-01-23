package com.learning.InterviewPreparation.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] numss = new int[2];
        ArrayList<Integer> list = new ArrayList<>();

        for(int nums1:nums){
            list.add(nums1);
        }

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            if(list.contains(target-num)){
                numss[0]=num;
                numss[1]=target-num;
            }
        }
        return numss;
    }


    public static void main(String... args){

        int[] arr = {2,7,11,15};
        Solution solution = new Solution();
        System.out.print(Arrays.toString(solution.twoSum(arr,9)));

    }
}
