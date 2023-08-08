package DefiningClasses.Exercises.LadyCat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Map<String, Cat> cats = new HashMap<>();


        while (!input[0].equals("End")) {
            String breed = input[0];
            String name = input[1];

            if (input[0].equals("Siamese")) {
                double earSize = Double.parseDouble(input[2]);
                Siamese siamese = new Siamese(breed, name, earSize);
                cats.putIfAbsent(name, siamese);
            } else if (breed.equals("Cymric")) {
                double furLength = Double.parseDouble(input[2]);
                Cymric cymric = new Cymric(breed, name, furLength);
                cats.putIfAbsent(name, cymric);
            } else if (breed.equals("StreetExtraordinaire")) {
                double decibels = Double.parseDouble(input[2]);
                StreetExtraordinaire cat = new StreetExtraordinaire(breed, name, decibels);
                cats.putIfAbsent(name, cat);
            }

            input = scanner.nextLine().split("\\s+");
        }
        String catName = scanner.nextLine();

        if (cats.containsKey(catName)) {
            System.out.print(cats.get(catName).toString());
        }
    }
}
