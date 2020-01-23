package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo1;

public class DomesticRate extends Rate{

    DomesticRate(double rate){
        super(rate);
    }

    @Override
    public double getRate(){
        return super.rate;
    }
}
