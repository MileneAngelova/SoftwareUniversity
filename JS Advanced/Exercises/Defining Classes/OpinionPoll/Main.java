package DefiningClasses.Exercises.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n > 0) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);

            Person person = new Person(name, age);
            people.add(person);

            n--;
        }

        people.stream().filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
