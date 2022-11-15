package ru.maki;

public class Electric extends VehicleTypeByFuelTypes{
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.ELECTRIC.name();
    }
}
