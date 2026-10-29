package Practical_11.Practical_11B;

import java.io.Serializable;

public abstract class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String accountNumber;
    protected long balance;
    protected Customer customer;

    public Account(String accountNumber,
                   long balance,
                   Customer customer) {

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void deposit(long amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(long amount) {

        if (amount > 0 && canWithdraw(amount)) {

            balance -= amount;
            return true;
        }

        return false;
    }

    public abstract boolean canWithdraw(long amount);

    @Override
    public String toString() {

        return "Account: " + accountNumber
                + ", Customer: " + customer
                + ", Balance: " + balance;
    }
}