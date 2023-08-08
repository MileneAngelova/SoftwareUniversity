package DefiningClasses.Exercises.LadyCat;

public class Cat {
    private String breed;
    private String catName;

    public Cat(String breed, String catName) {
        this.breed = breed;
        this.catName = catName;
    }

    public String getBreed() {
        return breed;
    }

    public String getCatName() {
        return catName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.breed, this.catName);
    }
}
