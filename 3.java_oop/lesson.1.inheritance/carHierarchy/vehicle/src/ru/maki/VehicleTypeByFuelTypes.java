package ru.maki;

public class VehicleTypeByFuelTypes extends VehicleType {

    public VehicleTypeByFuelTypes() {
        super("Vehicle type by fuel");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;

        VehicleTypeByFuelTypes that = (VehicleTypeByFuelTypes) obj;
        return attribute != null && attribute.equals(that.attribute);
    }
}
