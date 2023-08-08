package DefiningClasses.Exercises.LadyCat;

public class StreetExtraordinaire extends Cat {
    private double decibels;

    public StreetExtraordinaire(String breed, String catName, double decibels) {
        super(breed, catName);
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getCatName(), this.decibels);
    }
}
