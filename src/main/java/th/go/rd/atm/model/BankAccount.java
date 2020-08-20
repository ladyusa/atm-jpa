package th.go.rd.atm.model;

public class BankAccount {
    private double balance;
    public void deposit(double amount) {
        balance = balance + amount;
    }
    public void withdraw(double amount) {
        balance = balance - amount;
    }
    public double getBalance() {
        return balance;
    }
}
