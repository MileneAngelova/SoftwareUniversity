package DefiningClasses.Exercises.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        while (numberOfCars > 0) {
            String[] carInfo = scanner.nextLine().split("\\s+");

            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelPerKilometer = Double.parseDouble(carInfo[2]);

            Car car = new Car(model, fuelAmount, fuelPerKilometer);
            cars.put(model, car);

            numberOfCars--;
        }

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("End")) {
            String carModel = input[1];
            int distanceToTravel = Integer.parseInt(input[2]);

            Car car = cars.get(carModel);

            if (!car.drive(distanceToTravel)) {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine().split("\\s+");
        }

        cars.values().forEach(System.out::println);
    }
}
