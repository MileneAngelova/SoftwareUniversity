package InterfacesAndAbstraction.CarShopExtend;

public class Seat extends CarImpl implements Sellable {

    private final Double price;

    protected Seat(String model, String color, Integer horsepower, String countryProduced, Double price) {
        super(model, color, horsepower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + String.format("Leon sells for %f", this.price);
    }
}
