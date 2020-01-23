package com.learning.Java8NewFeature.LambdaExpression.Lambda3;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentTest {


        List<Student> list = new ArrayList<Student>() ;

        @Test(enabled = true)
        public void StudentDetails(){
        Student info = null;

        UserProfile profile = (x,y) -> {return new Student(x,y);};

        info = (Student)profile.addStudent(1,"Rahul");
        list.add(info);
        //info.setStudent((Student)profile.addStudent(1,"test"));
        //info.setStudent((Student)profile.addStudent(2,"test1"));

        info = (Student)profile.addStudent(2,"Mendiratta");
        list.add(info);
        info.setStudent(list);
        Iterator<Student> iterator = info.getStudent().iterator();

        while(iterator.hasNext()){
            Student student = iterator.next();
            System.out.print(student.getName()+"\n"+student.getRollNumber()+"\n");
        }

        }


}
