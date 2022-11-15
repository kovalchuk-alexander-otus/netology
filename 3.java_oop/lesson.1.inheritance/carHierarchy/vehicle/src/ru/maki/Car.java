package ru.maki;

public class Car extends VehicleTypeByPurpose{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.CAR.name();
    }
}
