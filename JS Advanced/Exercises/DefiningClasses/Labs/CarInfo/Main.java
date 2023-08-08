package DefiningClasses.Labs.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (number > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String brand = input[0];
            String model = input[1];
            int horsepower = Integer.parseInt(input[2]);

            Car car = new Car(brand, model, horsepower);
            cars.add(car);

            number--;
        }

        cars.forEach(c -> System.out.println(c.toString()));
    }
}
