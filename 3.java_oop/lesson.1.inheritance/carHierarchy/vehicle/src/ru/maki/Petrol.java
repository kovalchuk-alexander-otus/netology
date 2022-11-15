package ru.maki;

public class Petrol extends VehicleTypeByFuelTypes{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.PETROL.name();
    }
}
