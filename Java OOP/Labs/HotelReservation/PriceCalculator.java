package WorkingWithAbstractionsLab.HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int daysCount;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int daysCount, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.daysCount = daysCount;
        this.season = season;
        this.discountType = discountType;
    }

    private double calculatePrice() {
        return this.pricePerDay * this.season.getMultiplayer() * this.daysCount;
    }

    public double calculateTotalPrice(DiscountType discountType) {
        return calculatePrice() - calculatePrice() * discountType.getDiscount();
    }
}
