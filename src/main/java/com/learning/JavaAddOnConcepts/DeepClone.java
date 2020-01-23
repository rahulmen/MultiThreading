package com.learning.JavaAddOnConcepts;

import org.testng.annotations.Test;



     class Test1{
        int a,b;
        Test1(){super();}
    }

    class Test2 implements Cloneable{

        int i,j;
        Test1 test1 = new Test1();

        Test2(){super();}

        @Override
        protected Object clone() throws CloneNotSupportedException{
            Test2 test2 = (Test2)super.clone();
            test2.test1=new Test1(); //Return new Object not the same
            return test2;
        }
    }


public class DeepClone {

    @Test
    public void deepClone() throws CloneNotSupportedException{
        Test2 test2 = new Test2();
        test2.i=10;
        test2.j=20;
        test2.test1.a=30;
        test2.test1.b=40;

        //Perform Clonning

        Test2 test21 = (Test2)test2.clone();

        test21.i=40;
        test21.test1.b=50;

        System.out.print("Sum of test1 intance memebers value :"+(test2.i+test2.j+test2.test1.a+test2.test1.b)+"\n"); //100
        System.out.print("Sum of test2 intance memebers value :"+(test21.i+test21.j+test21.test1.a+test21.test1.b)); //110
    }


}


