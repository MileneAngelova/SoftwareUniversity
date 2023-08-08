package DefiningClasses.Labs.BnacAccount;

import DefiningClasses.Labs.BnacAccount.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String command = input[0];
        Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!command.equals("End")) {
            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accounts.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created%n", bankAccount.getId());
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(input[1]);
                double amount = Double.parseDouble(input[2]);
                if (accounts.containsKey(id)) {
                    accounts.get(id).deposit(amount);
                    System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(input[1]);
                int years = Integer.parseInt(input[2]);
                if (accounts.containsKey(id)) {
                    accounts.get(id).getInterest(years);
                System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(input[1]);
                BankAccount.setInterestRate(interest);
            }

            input = scanner.nextLine().split("\\s+");
            command = input[0];
        }
    }
}
