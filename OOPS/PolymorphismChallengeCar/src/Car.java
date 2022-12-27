public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Car -> startEngine");
    }

    protected void runEngine() {
        System.out.println("Car -> runEngine");
    }

    public void drive() {
        System.out.println("Car -> driving, type is " + getClass().getSimpleName());
        runEngine();
    }
}

class GasPoweredCar extends Car {

    private double avgKmPerLiter;
    private int cylinders = 6;

    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double avgKmPerLiter, int cylinders) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Gas -> All %d cylinders are fired up, Ready!%n", cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Gas -> usage exceeds the average: %.2f %n", avgKmPerLiter);
    }
}

class ElectricCar extends Car {
    double avgKmPerCharge;
    int batterySize;

    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        System.out.printf("Electric -> All %d batteries are fired up, Ready!%n", batterySize);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Electric -> usage exceeds the average: %.2f %n", avgKmPerCharge);
    }


}


class HybridCar extends Car {
    double avgKmPerLitre;
    int batterSize;
    int cylinders;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPerLitre, int batterSize, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterSize = batterSize;
        this.cylinders = cylinders;
    }


    @Override
    public void startEngine() {
        System.out.printf("Hybrid -> All %d cylinders & %s fuels are fired up, Ready!%n", cylinders, avgKmPerLitre);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Hybrid -> usage exceeds the average: %.2f %n", avgKmPerLitre);
    }
}
