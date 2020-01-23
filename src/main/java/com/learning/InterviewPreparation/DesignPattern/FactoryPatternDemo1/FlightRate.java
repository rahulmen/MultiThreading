package com.learning.InterviewPreparation.DesignPattern.FactoryPatternDemo1;

public class FlightRate {


    public static Rate getFlightRate(String name){
        if(name==null){
            return null;
        }
        else if(name.equalsIgnoreCase("Domestic")){
            return new DomesticRate(12.23);
        }
        else if(name.equalsIgnoreCase("International")){
            return new InternationalRate(45.34);
        }
        return null;
    }

}
