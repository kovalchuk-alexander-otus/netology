import ru.maki.*;

public class Main {
    public static void main(String[] args) {

        AdsService adsService = new AdsService();
        adsService.regAuto(new VehicleAd("volvo", new Sedan(), new Diesel(), new Passenger()));
        adsService.regAuto(new VehicleAd("lada", new Bus(), new Electric(), new Car()));
        adsService.regAuto(new VehicleAd("rzd", new Wagon(), new Hybrid(), new Truck()));
        adsService.regAuto(new VehicleAd("bmv", new Sedan(), new Petrol(), new Passenger()));
        adsService.regAuto(new VehicleAd("audi", new Sedan(), new Electric(), new Passenger()));
        adsService.regAuto(new VehicleAd("volksvagen", new Pickup(), new Diesel(), new Car()));

        System.out.println(adsService.toString());


        // поищем SEDAN
        adsService.filterByBody(new Sedan());

        System.out.println("\n\n");

        // поищем PETROL
        adsService.filterByFuels(new Diesel());

        System.out.println("\n\n");

        // поищем TRUCK
        adsService.filterByPurpose(new Truck());
    }
}