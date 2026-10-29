package Practical_10.Practical_10B;

public class Account {

    private String accountNumber;
    private long balance;

    public Account(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount) {

        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public synchronized boolean withdraw(long amount) {

        if (amount > 0 && balance >= amount) {

            balance = balance - amount;
            return true;
        }

        return false;
    }
}