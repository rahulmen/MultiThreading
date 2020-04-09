package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo1;

public class InternationalRate extends Rate{

    InternationalRate(double rate){
        super(rate);
    }

    @Override
    public double getRate(){
        return super.rate;
    }
}
