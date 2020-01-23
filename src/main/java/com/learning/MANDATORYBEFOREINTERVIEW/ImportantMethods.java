package com.learning.MANDATORYBEFOREINTERVIEW;

import java.util.Arrays;

public class ImportantMethods {

    static class Customer{
        String name;

        Customer(String name){
            this.name=name;
        }

        public String getName(){
            return this.name;
        }

    }

    public static void main(String... args){

        //Defining Array of Type Customer
        Customer[] customers = {new Customer("Rahul"),new Customer("Mendiratta"),new Customer("Is"),new Customer("My"),new Customer("Name")};

        for(Customer customer:customers){
            System.out.print(customer.getName()+" ");
        }

        System.out.println();

        char[] ch = customers[0].getName().toCharArray();

        for(char ch1:ch){
            System.out.print(ch1+" ");
        }

        System.out.println();

        for(Customer customer:customers){
            System.out.print(customer.getName().charAt(0)+" ");
        }

        System.out.println();

        for (Customer customer : customers) {
            System.out.print(customer.getName().substring(0, 2) + " " + "|| ");
        }

        System.out.println();

        for (Customer customer : customers) {
            char[] name = customer.getName().toCharArray();

            int i=0;
            while(i<name.length){
                System.out.print(name[i]+":"+Integer.valueOf(name[i])+"|");
                i++;
            }
            System.out.println();
        }

        System.out.println("\n"+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+"\n");

        Customer[] customers1 = Arrays.copyOf(customers,10);

        for(Customer customer:customers1){
            if(customer!=null) {
                System.out.print(customer.getName() + " ");
            }else{
                continue;
            }
        }

        System.out.println();

        Customer[] customers3 = new Customer[10];
        System.arraycopy(customers1,2,customers3,1,3);

        for(Customer customer3:customers3){
            if(customer3!=null) {
                System.out.print(customer3.getName() + " ");
            }else{
                continue;
            }
        }

        System.out.println();

        int [] arr = {3,1,5,3,2,6,8,7};Arrays.sort(arr);System.out.print(Arrays.toString(arr));














    }

}
