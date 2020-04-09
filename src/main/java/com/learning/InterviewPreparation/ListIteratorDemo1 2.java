package com.learning.InterviewPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo1 {


    public static void main(String... args){


        List<Object> list = new ArrayList<Object>(Arrays.asList(3,5,2,7,9));

        list.add(11);

        System.out.println(list);

        ListIterator<Object> listIterator = list.listIterator();


        while(listIterator.hasNext()){

            System.out.println(listIterator.next()+" "+listIterator.nextIndex());
            System.out.println();

        }

        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous()+" "+listIterator.previousIndex());
            System.out.println();
        }

        listIterator.set(4);

        System.out.println(list);

    }


}
