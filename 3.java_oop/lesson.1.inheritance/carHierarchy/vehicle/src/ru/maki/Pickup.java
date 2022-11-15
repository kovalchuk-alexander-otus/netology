package ru.maki;

public class Pickup extends VehicleTypeByBodyTypes{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.PICKUP.name();
    }
}
