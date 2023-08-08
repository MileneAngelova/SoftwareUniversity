package DefiningClasses.Exercises.LadyCat;

public class Siamese extends Cat {
    private double earsSize;
    public Siamese(String breed, String catName, double earsSize) {
        super(breed, catName);
        this.earsSize = earsSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getCatName(), this.earsSize);
    }
}
