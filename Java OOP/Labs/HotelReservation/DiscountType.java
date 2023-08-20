package WorkingWithAbstractionsLab.HotelReservation;

public enum DiscountType {
    VIP(0.2),
    SecondVisit(0.1),
    None(0);

   private double discount;

    public double getDiscount() {
        return discount;
    }

    DiscountType(double discount) {
        this.discount = discount;
    }
}
