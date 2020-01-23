package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

import java.util.*;

public class VectorDemo1 {

    public static void main(String[] args){

        Vector<Object> list = new Vector<Object>();
        List<Object> list2 = new ArrayList<>(Arrays.asList(2,53,2321,432,432,5432));


        list.addElement("123");
        list.addElement("123");
        list.addElement("123");
        list.addElement("123");
        list.addElement("123");

        Enumeration iterator = list.elements();

        while(iterator.hasMoreElements()){
            System.out.print(iterator.nextElement());
        }
        

    }


}
