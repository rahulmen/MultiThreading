package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

/*
* In ArrayList Insertion Order is maintained
* Duplicates are also allowed
* null insertion is also possible
* ArrayList Class has implemented the Serilizable and Colonable marker interface.
* Collection override the Object Class toString() method to print the content not the Object
*
*
* ArrayList class for RandomAccess O(1) has implemented RandomAccess marker Interface
*
* ArrayList is suitable if out best Operation is retrival but worst choice if our Operation is inserion and Deletion in the middle
*
* If our need is insertion and Deletion in midle then LinkedList is the Best Choice.
*
* We can store hetrogenous element in Linked List and element are displayed in square bracket [].
*
* The difference b/w ArrayList and Vector is ArrayList is not ThreadSafe but Vector is the legacy Class which is ThreadSafe as every
* method in Vector is Synchronised.
*
* We can not use legacy iterator Enumeration for ArrayList because it is not supported
*
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo1 {

    public static class Student{

        String name;
        int rollNunber;
        Class cls;

        Student(String name,int rollNunber,Class cls){
          this.name=name;
          this.rollNunber=rollNunber;
          this.cls=cls;
        }

    }

    public static enum Class{

        FIRSTCLASS,
        SECONDCLASS,
        THIRDCLASS,
        FOURTHCLASS,
        FIFTHCLASS,
        SIXTHCLASS,
        SEVENTHCLASS;

    }

    public static void main(String[] args){


        List<Student> list = new ArrayList<Student>(10);

        list.add(new Student("Rahul01",01,Class.FIRSTCLASS)); //Insertion Order is also maintained
        list.add(new Student("Rahul02",02,Class.SECONDCLASS));
        list.add(new Student("Rahul03",03,Class.THIRDCLASS));
        list.add(new Student("Rahul04",04,Class.FOURTHCLASS));
        list.add(new Student("Rahul05",05,Class.FIFTHCLASS));
        list.add(new Student("Rahul05",05,Class.FIFTHCLASS)); //Duplicates are allowed
        list.add(2,new Student("Rahul08",06,Class.SIXTHCLASS));
        list.add(7,new Student("Rahul09",07,Class.SEVENTHCLASS));
        System.out.print(list.indexOf(4));

        Iterator<Student> iterator = list.iterator();

        while(iterator.hasNext()){
            Student object = (Student)iterator.next();
            try {
                System.out.println(object.name+" "+object.rollNunber+" "+object.cls.name());
            }catch(NullPointerException nsee){
            }
        }


        //To get Synchronised version of ArrayList we can use Collections Class which is the Utility Class.

        List<Student> list2 = Collections.synchronizedList(list);


        for(Student obj : list2){
            System.out.println(obj.name+" "+obj.rollNunber+" "+obj.cls);

        }







    }


}
