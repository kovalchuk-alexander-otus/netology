package ru.maki;

public class Sedan extends VehicleTypeByBodyTypes{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.SEDAN.name();
    }
}
