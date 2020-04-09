package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo2;

public class MicroCar extends Car {

    MicroCar(CarType carType){
        super(carType);
        carfeature();
    }

    @Override
    public void carfeature(){
        System.out.println("MICRO CAR IS A SMALL CAR");
    }
}
