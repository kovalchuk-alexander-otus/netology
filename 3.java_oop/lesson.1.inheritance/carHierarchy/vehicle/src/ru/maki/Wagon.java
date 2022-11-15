package ru.maki;

public class Wagon extends VehicleTypeByBodyTypes{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.WAGON.name();
    }
}
