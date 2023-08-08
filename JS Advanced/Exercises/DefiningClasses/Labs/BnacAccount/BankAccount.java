package DefiningClasses.Labs.BnacAccount;

public class BankAccount {

    private static int accountsCount = 1;
    private int id;
    private double balance;
    private static double interestRate;

    public BankAccount() {
       this.id = accountsCount;
        accountsCount++;
        interestRate = 0.02;
    }

    public int getId() {
        return id;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
