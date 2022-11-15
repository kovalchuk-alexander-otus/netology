package ru.maki;

public class VehicleTypeByBodyTypes extends VehicleType {

    public VehicleTypeByBodyTypes() {
        super("Vehicle type by body");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;

        VehicleTypeByBodyTypes that = (VehicleTypeByBodyTypes) obj;
        return attribute != null && attribute.equals(that.attribute);
    }
}
