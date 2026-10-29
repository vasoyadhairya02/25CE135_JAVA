package Practical_9.Practical_9B;

public class SavingsAccount extends Account {

    private long minBalance;

    public SavingsAccount(String accountNumber,
                          String holderName,
                          long balance,
                          long minBalance) {

        super(accountNumber, holderName, balance);

        this.minBalance = minBalance;
    }

    @Override
    public boolean canWithdraw(long amount) {

        return balance - amount >= minBalance;
    }
}