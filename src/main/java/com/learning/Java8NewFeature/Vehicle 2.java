package com.learning.Java8NewFeature;

import java.io.Serializable;

public interface Vehicle extends Serializable,Cloneable {

    /*
    This method cant be overriden as it is static we can perform method hiding
     */
    static void getManufacturerInfo(String manufacturerName){
         System.out.println("Car is manufactured by : "+manufacturerName);
    }

    /*
    This method can be overriden
     */

    default void getVehicleInfo(String name){
        System.out.println("This is a Default Car Info");
         getManufacturerInfo(name);
    }



}
