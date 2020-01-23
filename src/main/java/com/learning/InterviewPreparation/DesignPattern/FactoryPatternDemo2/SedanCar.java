package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo2;

public class SedanCar extends Car {

    SedanCar(CarType carType){
        super(carType);
        carfeature();
    }

    @Override
    public void carfeature(){
        System.out.print("SEDAN CAR IS A BIG CAR");
    }
}
