package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo1;

public abstract class Rate {

    double rate;

    public abstract double getRate();

    Rate(double rate){
        this.rate=rate;
    }

}
