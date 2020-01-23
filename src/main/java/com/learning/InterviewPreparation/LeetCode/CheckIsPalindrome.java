package com.learning.InterviewPreparation.LeetCode;




























public class CheckIsPalindrome {


    public boolean isPalindrome(int x) {

        if(x<=0 || x%10==0){
            return false;
        }

        int revertedNumber = 0;


        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }


        return x == revertedNumber || x == revertedNumber/10;

    }


    /*
        public boolean isPalindrome(int x) {

         String number  = String.valueOf(x);
         int i=number.length()-1;

         String temp = "";
         while(i>=0){
            temp = temp+number.charAt(i);
            i--;
         }
         int j=0;

         if(number.equals(temp)){
             return true;
         }else{
             return false;
         }
        }
*/

        public static void main(String... args){

         System.out.print(new CheckIsPalindrome().isPalindrome(121));


        }



}
