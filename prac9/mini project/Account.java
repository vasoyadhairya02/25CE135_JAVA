package Practical_9.Practical_9B;

public abstract class Account {

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

    public synchronized void deposit(long amount) {

        if (amount > 0) {

            balance = balance + amount;
        }
    }

    public synchronized boolean withdraw(long amount) {

        if (amount > 0 && canWithdraw(amount)) {

            balance = balance - amount;
            return true;
        }

        return false;
    }

    public abstract boolean canWithdraw(long amount);
}