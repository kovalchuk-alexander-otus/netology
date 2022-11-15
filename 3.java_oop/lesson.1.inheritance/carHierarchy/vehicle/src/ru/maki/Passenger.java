package ru.maki;

public class Passenger extends VehicleTypeByPurpose{
    @Override
    public String getTypeName(){
        return VehicleTypeEnum.PASSENGER.name();
    }
}
