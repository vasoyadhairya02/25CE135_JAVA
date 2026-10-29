package Practical_14.Practical_14B;

public class SavingsAccount extends Account {

    private static final long serialVersionUID = 1L;

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

    @Override
    protected long calculateShortfall(long amount) {

        long required =
                amount + minBalance;

        return Math.max(
                0,
                required - balance);
    }
}