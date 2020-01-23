package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo2;

public class UserFace {


    public static void main(String[] args){

        Car car = CarFactory.getCar(CarType.MINI);
        System.out.print(car.carType.name());


    }



}

