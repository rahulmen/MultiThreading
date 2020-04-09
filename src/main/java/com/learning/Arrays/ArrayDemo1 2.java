package com.learning.Arrays;

/*
* 1.This program demonstrate how we can define Array of user-defined data type.
* 2. If we will assign initilaised array to some other reference and using that new reference id we will change value of any index it will
*   be reflected in both the reference
*
* Note :- AS BOTH REFERENCE IS POINTING TO THE SAME ARRAY
 */

class Student{
    String name;
    String roolNum;

    Student(String name,String roolNum){
        this.name=name;
        this.roolNum=roolNum;
    }
}

public class ArrayDemo1 {


    public static void main(String[] args){

        Student[] student; //Student Class array reference
        Student[] newStudent;


        student = new Student[5];
        student[0]= new Student("Rahul","01");
        student[1]= new Student("Rahul1","02");
        student[2]= new Student("Rahul2","03");
        student[3]= new Student("Rahul3","04");
        student[4]= new Student("Rahul4","05");

        newStudent=student;  //new Student will also point to same address as that of student


        System.out.println("\n"+"ARRAY1 values:");
        for(Student student1:student){
            System.out.print("\n"+"Name :"+student1.name+"\n"+"RoolNumber: "+student1.roolNum+"\n"+"=======");
        }

        System.out.println("\n\n"+"ARRAY2 values:");
        for(Student student1:newStudent){
            System.out.print("\n"+"Name :"+student1.name+"\n"+"RoolNumber: "+student1.roolNum+"\n"+"=======");

        }

    }

}


