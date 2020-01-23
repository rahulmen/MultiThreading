package com.learning.Java8NewFeature.LambdaExpression.Lambda3;


@FunctionalInterface
public interface UserProfile<Student> {

    Student addStudent(int rollNumber,String name);

}
