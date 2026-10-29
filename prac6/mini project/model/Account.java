package Practical_6.model;

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

    public long getBalance() {
        return balance;
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);
}