package Practical_5;

public abstract class Account {

    protected String accountNumber;
    protected String holderName;
    protected long balance;

    public Account(String accountNumber, String holderName, long balance) {
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
            balance = balance + amount;
        }
    }

    public boolean withdraw(long amount) {

        if (amount > 0 && canWithdraw(amount)) {
            balance = balance - amount;
            return true;
        }

        return false;
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    public double monthlyInterest() {
        return balance * (interestRate() / 100) / 12;
    }
}