package com.learning.Java8NewFeature;

public class VehicleImpl implements Vehicle{


    @Override
     public void getVehicleInfo(String name){
        System.out.println("This is a Manufaturer Car Info");
        Vehicle.getManufacturerInfo(name);
    }



    public static void main(String[] args){

        VehicleImpl vehicle = new VehicleImpl();
        vehicle.getVehicleInfo("Audi");


        Vehicle vehicle1 = new VehicleImpl();
        vehicle1.getVehicleInfo("Mercedes");


    }



}
