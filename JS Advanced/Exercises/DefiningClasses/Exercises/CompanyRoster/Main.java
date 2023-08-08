package DefiningClasses.Exercises.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        while (countPeople > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String department = input[3];

            Employee employee = createEmployee(input, department);

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);

            countPeople--;
        }

        Department highestSalary = departments.entrySet().stream()
                .max(Comparator.comparing(e -> e.getValue().calculateAverageSalary()))
                .get().getValue();

        System.out.printf("Highest Average Salary: %s%n", highestSalary.getName());
        highestSalary.getEmployees().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }

    public static Employee createEmployee(String[] info, String department) {
        String name = info[0];
        double salary = Double.parseDouble(info[1]);
        String position = info[2];
        String email = "n/a";
        int age = -1;

        Employee employee = new Employee(name, salary, position, department, email, age);

        if (info.length == 5) {
            try {
                age = Integer.parseInt(info[4]);
                employee.setAge(age);
            } catch (NumberFormatException exception) {
                email = info[4];
                employee.setEmail(email);
            }
        } else if (info.length == 6) {
            email = info[4];
            age = Integer.parseInt(info[5]);
            employee.setEmail(email);
            employee.setAge(age);
        }
        return employee;
    }
}
