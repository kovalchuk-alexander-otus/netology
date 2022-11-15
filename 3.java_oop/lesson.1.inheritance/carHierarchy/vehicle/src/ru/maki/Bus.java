package ru.maki;

public class Bus extends VehicleTypeByBodyTypes{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.BUS.name();
    }
}
