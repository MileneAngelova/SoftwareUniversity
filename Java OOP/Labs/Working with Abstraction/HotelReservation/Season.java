package WorkingWithAbstractionsLab.HotelReservation;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int multiplayer;

    public int getMultiplayer() {
        return multiplayer;
    }

    Season(int multiplayer) {
        this.multiplayer = multiplayer;
    }
}