package Practical_13.Practical_13B;

public class SavingsAccount extends Account {

    private long minBalance;

    public SavingsAccount(String accountNumber,
                          String holderName,
                          long balance,
                          long minBalance) {

        super(accountNumber, holderName, balance);

        this.minBalance = minBalance;
    }

    public long getMinBalance() {
        return minBalance;
    }
}