package DefiningClasses.Exercises.Google;

public class Parents {
    private String name;
    private String birthday;

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.name, this.birthday);
    }
}
