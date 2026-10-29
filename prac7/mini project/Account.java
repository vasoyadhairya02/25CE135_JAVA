package Practical_7;

public abstract class Account {

    @Id
    @MaxLength(10)
    protected String accountNumber;

    @MaxLength(30)
    protected String holderName;

    @Positive
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

    @Override
    public String toString() {

        return "Account Number: " + accountNumber
                + ", Holder: " + holderName
                + ", Balance: " + balance;
    }
}
