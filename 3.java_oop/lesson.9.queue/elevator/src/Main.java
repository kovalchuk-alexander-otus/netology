import ru.maki.Elevator;

public class Main {
    public static void main(String[] args) {

        Elevator elevator = new Elevator(0, 25);

        elevator.liftRide();
        elevator.tripReport();

    }
}