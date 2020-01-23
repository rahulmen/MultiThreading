package com.learning.Deleted;

public class FlowControlExample1 {

    //Static block  1.(identify)  5.(Execute)
    static{
        System.out.println("Static Block Executed");
    }


    //Instance Block  9. Identify 13.Execute
    {
        System.out.println("Instance Block Executed");
    }

    //Constructor  10.Identify  14. Execute
    FlowControlExample1(){
        System.out.println("Constructor Executed");
    }

    //Instance Variable 11. Identify  15. Intialise
    int a=10;
    //Static Variable  2.Identify 6.Intialise
    static int b = 20;

    //Static Method   3.  7. Execute
    public static void m1(){
        System.out.println(b);
    }

    //Instance method  12. Identify  16. Execute
    public void m2(){
        System.out.println(b);
    }

    //Static main method 4.  8. Execute
    public static void main(String[] args){
        System.out.println(b);
        m1();
        FlowControlExample1 flowControlExample1 = new FlowControlExample1();
        flowControlExample1.m2();
        System.out.println(flowControlExample1.a);
    }

}