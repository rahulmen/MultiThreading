package com.learning.InterviewPreparation.LeetCode;

class ImplementStr {
    public int strStr(String haystack, String needle) {

        if(needle.length()==0){
            return 0;
        }

        if(haystack.contains(needle)){

            char[] hay = haystack.toCharArray();
            char[] nee = needle.toCharArray();

            for(int i=0;i<hay.length;i++){

                int neeIndex=0;
                if(hay[i]==nee[neeIndex]){

                    int begin = i;
                    while(neeIndex<=nee.length-1 && hay[begin]==nee[neeIndex]){
                        begin++;
                        neeIndex++;
                    }

                    if(neeIndex-1==nee.length-1){
                        return i;
                    }

                }else{
                    continue;
                }
            }
        }else{
            return -1;
        }
        return -1;
    }


    public static void main(String[] args){

        int index = new ImplementStr().strStr("hello","ll");

        System.out.print(index);

    }

}
