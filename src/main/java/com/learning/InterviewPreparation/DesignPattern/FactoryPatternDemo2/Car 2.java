package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo2;

public abstract class Car {

    public CarType carType;

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    Car(CarType carType){
        this.carType=carType;
        arrangeParts();
    }

    public void arrangeParts(){
        System.out.println("Arranging Basic Parts for Car Manufucturing");
    }

    public abstract void carfeature();

}
