package DefiningClasses.Exercises.LadyCat;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String breed, String catName, double furLength) {
        super(breed, catName);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getCatName(), this.furLength);
    }
}
