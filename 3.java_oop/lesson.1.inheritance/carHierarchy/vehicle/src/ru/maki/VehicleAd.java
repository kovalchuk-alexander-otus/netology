package ru.maki;

public class VehicleAd {
    private int id;
    private String model;
    private VehicleTypeByBodyTypes bodyType;
    private VehicleTypeByFuelTypes fuelType;
    private VehicleTypeByPurpose purpose;

    public VehicleAd(String model, VehicleTypeByBodyTypes bodyType, VehicleTypeByFuelTypes fuelType, VehicleTypeByPurpose purpose) {
        this.model = model;
        this.bodyType = bodyType;
        this.fuelType = fuelType;
        this.purpose = purpose;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleTypeByBodyTypes getBodyType() {
        return bodyType;
    }

    public VehicleTypeByFuelTypes getFuelType() {
        return fuelType;
    }

    public VehicleTypeByPurpose getPurpose() {
        return purpose;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
