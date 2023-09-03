package InterfacesAndAbstraction.CarShop;

public class Seat implements Car {
private final String model;
private final String color;
private final int horsepower;
private final String country;



    public Seat(String model, String color, int horsepower, String country) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.country = country;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsepower;
    }


    @Override
    public String countryProduced() {
        return this.country;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.model, this.country, Car.TIRES);
    }
}
