package com.learning.Questions.StringProblem;

public class NumArray {

    int nums[];

    public NumArray(int[] nums) {
        this.nums=nums;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        while(i<=j){
            sum+=this.nums[i];
        }
        return sum;
    }


    public static void main(String... args){

      //  NumArray numArray = new NumArray([[-2,0,3,-5,2,-1][0,2]]);

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */