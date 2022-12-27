public class Main {

    public static void main(String[] args) {

        Car car = new Car("2022 Blue Ferrari 296 GTS");
        runRace(car);

        Car ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTS",
                15.4, 6);
        runRace(ferrari);

        Car tesla = new ElectricCar("Tesla black 2.0 2022 AMT",
                120, 5000);
        runRace(tesla);

        Car celerio = new HybridCar("Celerio VXi CNG 2022",
                24, 3000, 4);
        runRace(celerio);
    }

    public static void runRace(Car car) {

        car.startEngine();
        car.drive();
    }
}

