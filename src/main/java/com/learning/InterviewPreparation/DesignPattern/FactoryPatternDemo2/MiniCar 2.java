package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo2;

public class MiniCar extends Car {

    MiniCar(CarType carType){
        super(carType);
        carfeature();
    }

    @Override
    public void carfeature(){
        System.out.print("MINI CAR IS A AVERAGE CAR");
    }
}
