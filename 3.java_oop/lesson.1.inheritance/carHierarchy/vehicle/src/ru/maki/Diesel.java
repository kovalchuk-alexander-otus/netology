package ru.maki;

public class Diesel extends VehicleTypeByFuelTypes{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.DIESEL.name();
    }
}
