package Practical_14.Practical_14B;

import java.io.Serializable;

public abstract class Account
        implements Serializable,
                   Comparable<Account> {

    private static final long serialVersionUID = 1L;

    @Id
    protected String accountNumber;

    protected String holderName;
    protected long balance;

    public Account(String accountNumber,
                   String holderName,
                   long balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount)
            throws InvalidAmountException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Amount must be greater than 0");
        }

        balance += amount;
    }

    public synchronized void withdraw(long amount)
            throws InvalidAmountException,
                   InsufficientFundsException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Amount must be greater than 0");
        }

        if (!canWithdraw(amount)) {

            throw new InsufficientFundsException(
                    "Insufficient balance",
                    calculateShortfall(amount));
        }

        balance -= amount;
    }

    protected long calculateShortfall(long amount) {

        return Math.max(0, amount - balance);
    }

    public abstract boolean canWithdraw(long amount);

    @Override
    public int compareTo(Account other) {

        return accountNumber.compareTo(
                other.accountNumber);
    }

    @Override
    public String toString() {

        return accountNumber
                + " | "
                + holderName
                + " | Balance: "
                + balance;
    }
}