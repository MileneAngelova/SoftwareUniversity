package DefiningClasses.Exercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String fullName;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;


    public Person(String name) {
        this.fullName = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public Car getCar() {
        return car;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.fullName)
                .append(System.lineSeparator())
                .append("Company:")
                .append(System.lineSeparator());
        if (company != null) {
            output.append(company.toString());
        }
        output.append("Car:")
                .append(System.lineSeparator());
        if (car != null) {
            output.append(car.toString());
        }
        output.append("Pokemon:").append(System.lineSeparator());
        if (pokemons.size() > 0) {
            for (Pokemon pokemon : pokemons) {
                output.append(pokemon.toString());
            }
        }
        output.append("Parents:").append(System.lineSeparator());
        if (parents.size() > 0) {
            for (Parents parent : parents) {
                output.append(parent.toString());
            }
        }
        output.append("Children:").append(System.lineSeparator());
        if (children.size() > 0) {
            for (Children child : children) {
                output.append(child.toString());
            }
        }
        return output.toString();
    }
}
