package Practical_12.Practical_12B;

public abstract class Account
        implements Comparable<Account> {

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

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(long amount) {

        if (amount > 0 && balance >= amount) {

            balance -= amount;
            return true;
        }

        return false;
    }

    @Override
    public int compareTo(Account other) {

        return this.accountNumber
                .compareTo(other.accountNumber);
    }

    @Override
    public String toString() {

        return accountNumber
                + " - "
                + holderName
                + " - Balance: "
                + balance;
    }
}