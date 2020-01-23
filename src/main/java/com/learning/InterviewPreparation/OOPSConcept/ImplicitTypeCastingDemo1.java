package com.learning.InterviewPreparation.OOPSConcept;

import static java.lang.System.out;

 class ImplicitTypeCastingDemo1 {

    public static void main(String[] args){

       int i = 100000;

       char ch = (char)i;
       byte b = (byte)i;

       out.println(ch);
        out.println(b);



    }



}
