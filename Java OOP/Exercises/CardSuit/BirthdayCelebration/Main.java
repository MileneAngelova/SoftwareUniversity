package Exercises.InterfacesAndAbstraction.BirthdayCelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        String command = data[0];

        List<Birthable> mammals = new ArrayList<>();

        while (!command.equals("End")) {
            if (command.equals("Citizen") || command.equals("Pet")) {
                Birthable birthable = data.length == 5
                        ? new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4])
                        : new Pet(data[1], data[2]);

                mammals.add(birthable);
            } else {
                Identifiable robot = new Robot(data[1], data[2]);
            }

            data = scanner.nextLine().split("\\s+");
            command = data[0];
        }

        String year = scanner.nextLine();

        System.out.println(mammals.stream().map(Birthable::getBirthDate)
                .filter(birthDate -> birthDate.endsWith(year))
                .collect(Collectors.joining(System.lineSeparator())));

    }
}
