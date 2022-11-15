package ru.maki;

public class Truck extends VehicleTypeByPurpose{
    @Override
    public String getTypeName(){
        return VehicleTypeEnum.TRUCK.name();
    }
}
