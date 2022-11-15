package ru.maki;

public abstract class VehicleType {
    protected String attribute;

    public VehicleType(String attribute) {
        this.attribute = attribute;
    }

    public String getTypeName() {
        return "Some Type name";
    }

}
