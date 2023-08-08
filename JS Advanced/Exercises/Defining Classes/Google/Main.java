package DefiningClasses.Exercises.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<String, Person> people = new HashMap<>();

        while (!input[0].equals("End")) {
            String personName = input[0];

            Person person = new Person(personName);
            people.putIfAbsent(personName, person);

            setData(input, person, people);


            input = scanner.nextLine().split("\\s+");
        }

        String name = scanner.nextLine();
        if (people.containsKey(name)) {
            System.out.println(people.get(name).toString());
        }
    }

    public static void setData(String[] input, Person person, Map<String, Person> peopleData) {
        String personName = input[0];

        if (input[1].equals("company")) {
            String companyName = input[2];
            String department = input[3];
            double salary = Double.parseDouble(input[4]);

            Company company = new Company(companyName, department, salary);
            company.setCompanyName(companyName);
            company.setDepartment(department);
            company.setSalary(salary);
            if (checkPerson(peopleData, personName)) {
                peopleData.get(person.getFullName()).setCompany(company);
            }
        } else if (input[1].equals("pokemon")) {
            String pokemonName = input[2];
            String type = input[3];

            Pokemon pokemon = new Pokemon(pokemonName, type);
            if (checkPerson(peopleData, personName)) {
                peopleData.get(person.getFullName()).getPokemons().add(pokemon);
            }
        } else if (input[1].equals("parents")) {
            String parentName = input[2];
            String parentBirthday = input[3];

            Parents parent = new Parents(parentName, parentBirthday);
            if (checkPerson(peopleData, personName)) {
                peopleData.get(person.getFullName()).getParents().add(parent);
            }
        } else if (input[1].equals("children")) {
            String childrenName = input[2];
            String childrenBirthday = input[3];

            Children child = new Children(childrenName, childrenBirthday);
            if (checkPerson(peopleData, personName)) {
                peopleData.get(person.getFullName()).getChildren().add(child);
            }
        } else if (input[1].equals("car")) {
            String model = input[2];
            int speed = Integer.parseInt(input[3]);

            Car car = new Car(model, speed);
            if (checkPerson(peopleData, personName)) {
                peopleData.get(person.getFullName()).setCar(car);
            }
        }
    }

    public static boolean checkPerson(Map<String, Person> data, String personName) {
        return data.containsKey(personName);
    }
}

