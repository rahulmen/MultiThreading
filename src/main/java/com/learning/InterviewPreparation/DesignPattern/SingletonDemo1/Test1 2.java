package com.learning.InterviewPreparation.DesignPattern.SingletonDemo1;

import java.io.*;

public class Test1 {

    public static void main(String... args) throws Exception{

        SingletonDemo1 singletonDemo1 = SingletonDemo1.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("demo.ser"));
        objectOutputStream.writeObject(singletonDemo1);
        objectOutputStream.close();

        singletonDemo1.setI(20);

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("demo.ser"));
        SingletonDemo1 singletonDemo2 = (SingletonDemo1) objectInput.readObject();
        objectInput.close();

        System.out.print(singletonDemo1.getI());
        System.out.print(singletonDemo2.getI());















    }

}
