package com.learning.InterviewPreparation.CollectionAndMapFrameWork;

import Stack.CustomStack;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator4 implements Comparator{

    @Override
    public int compare(Object obj1,Object obj2){

        Customer customer1 = (Customer)obj1;
        Customer customer2 = (Customer)obj2;
        return customer1.compareTo(customer2);
    }


}

class Customer implements Comparable<Customer>{

    private int age;

    Customer(int age){
        this.age=age;
    }

    @Override
    public String toString(){
        return "Customer :"+this.age;
    }

    @Override
    public int compareTo(Customer obj) {
        Integer age = obj.age;
        return age.compareTo(this.age);
    }
}

public class TreeSetDemo5 {

    public static void main(String... args){

        TreeSet<Customer> treeSet = new TreeSet<Customer>(new MyComparator4());
        treeSet.add(new Customer(3));
        treeSet.add(new Customer(5));
        treeSet.add(new Customer(1));
        treeSet.add(new Customer(7));
        treeSet.add(new Customer(9));

        System.out.print(treeSet);




    }


}
