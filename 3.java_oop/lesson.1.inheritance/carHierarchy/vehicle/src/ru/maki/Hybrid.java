package ru.maki;

public class Hybrid extends VehicleTypeByFuelTypes{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.HYBRID.name();
    }
}
