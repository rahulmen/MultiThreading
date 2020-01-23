package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo1;

import java.util.Scanner;

public class UserInfo {


    public static void main(String... args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the flight rate to get :");
        String name = scan.next();

        Rate rate = FlightRate.getFlightRate(name);
        System.out.println("Flight fee rate of "+name+" :" +rate.rate);

    }

}
