package DefiningClasses.Exercises.SpeedRacing;

public class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelPerKilometer;
    private int distance;

    public Car(String model, double fuelAmount, double fuelPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKilometer = fuelPerKilometer;
        distance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelPerKilometer() {
        return fuelPerKilometer;
    }

    public int getDistance() {
        return distance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    public double maxDistance() {
        return this.fuelAmount / this.fuelPerKilometer;
    }

    public boolean drive(double distanceToTravel) {
        if (distanceToTravel <= maxDistance()) {
            double neededFuel = distanceToTravel * this.fuelPerKilometer;
            this.fuelAmount -= neededFuel;
            this.distance += distanceToTravel;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}
