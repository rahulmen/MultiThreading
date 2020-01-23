package com.learning.Java8NewFeature.LambdaExpression.Lambda3;

import java.util.ArrayList;
import java.util.List;

public class Student {

    int rollNumber;
    String name;

    List<Student> list = new ArrayList<Student>();

    public Student(int rollNumber, String name){
        this.rollNumber=rollNumber;
        this.name=name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent(List<Student> student){
        this.list=student;
    }

    public List<Student> getStudent(){
        return list;
    }

}
