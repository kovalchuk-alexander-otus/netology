package ru.maki;

import java.util.Arrays;

public class AdsService {
    private VehicleAd[] vehicleAds;
    private int nextId;

    public AdsService() {
        this.vehicleAds = new VehicleAd[0];
        this.nextId = 1;
    }

    public void regAuto(VehicleAd vehicleAd){
        vehicleAd.setId(this.nextId++);
        VehicleAd[] temp = Arrays.copyOf(vehicleAds, vehicleAds.length+1);

        temp[this.vehicleAds.length] = vehicleAd;
        this.vehicleAds = temp;
    }

    public void filterByBody(VehicleTypeByBodyTypes vehicleTypeByBodyTypes){
        for (VehicleAd vehicleAd : vehicleAds) {
            if (vehicleAd.getBodyType().equals(vehicleTypeByBodyTypes)) System.out.println(vehicleAd.toString());
        }
    }

    public void filterByFuels(VehicleTypeByFuelTypes vehicleTypeByFuelTypes){
        for (VehicleAd vehicleAd : vehicleAds) {
            if (vehicleAd.getFuelType().equals(vehicleTypeByFuelTypes)) System.out.println(vehicleAd.toString());
        }
    }

    public void filterByPurpose(VehicleTypeByPurpose vehicleTypeByPurpose){
        for (VehicleAd vehicleAd : vehicleAds) {
            if (vehicleAd.getPurpose().equals(vehicleTypeByPurpose)) System.out.println(vehicleAd.toString());
        }
    }

    @Override
    public String toString() {
        return "AdsService{" +
                "vehicleAds=" + Arrays.toString(vehicleAds) +
                ", nextId=" + nextId +
                '}';
    }
}
