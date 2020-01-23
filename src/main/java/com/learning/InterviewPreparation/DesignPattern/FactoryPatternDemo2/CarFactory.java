package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo2;

public class CarFactory {

    public static Car getCar(CarType carType){

        switch (carType){
            case MICRO:{
                return new MicroCar(CarType.MICRO);
            }
            case MINI:{
                return new MiniCar(CarType.MINI);
            }
            case SEDAN:{
                return new SedanCar(CarType.SEDAN);
            }
        }
        return null;
    }
}
