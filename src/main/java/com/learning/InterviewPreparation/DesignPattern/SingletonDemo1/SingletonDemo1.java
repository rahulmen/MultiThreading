package com.learning.InterviewPreparation.DesignPattern.SingletonDemo1;

import java.io.Serializable;

public class SingletonDemo1 implements Serializable {

    private SingletonDemo1(){

    }

    private static SingletonDemo1 singletonDemo1 = null;

    /*
    * This method will return the instance of SingletonDemo1 if instance is null
     */

    public static SingletonDemo1 getInstance(){

        if(singletonDemo1==null){
            synchronized (SingletonDemo1.class){
                if(singletonDemo1==null){
                    singletonDemo1=new SingletonDemo1();
                }
            }
        }
        return singletonDemo1;
    }


    protected Object readResolve(){
     return singletonDemo1;
    }

    private int i=10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
