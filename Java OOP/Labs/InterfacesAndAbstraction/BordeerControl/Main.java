package InterfacesAndAbstraction.BordeerControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        String command = data[0];

        List<Identifiable> creatures = new ArrayList<>();

        while (!command.equals("End")) {
            Identifiable identifiable = data.length == 3
                    ? new Citizen(data[0], Integer.parseInt(data[1]), data[2])
                    : new Robot(data[0], data[1]);
            creatures.add(identifiable);

            data = scanner.nextLine().split("\\s+");
            command = data[0];
        }

        String fakeId = scanner.nextLine();

        for (Identifiable creature : creatures) {
            if (creature.getId().endsWith(fakeId)) {
                System.out.println(creature.getId());
            }
        }
//        System.out.println(creatures.stream().filter(c -> c.getId().endsWith(fakeId))
//                .map(Identifiable::getId)
//                .collect(Collectors.joining(System.lineSeparator())));

    }
}
