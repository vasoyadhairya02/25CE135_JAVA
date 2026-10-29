package Practical_14.Practical_14B;

public class CurrentAccount extends Account {

    private static final long serialVersionUID = 1L;

    private long overdraftLimit;

    public CurrentAccount(String accountNumber,
                          String holderName,
                          long balance,
                          long overdraftLimit) {

        super(accountNumber, holderName, balance);

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean canWithdraw(long amount) {

        return balance - amount >= -overdraftLimit;
    }

    @Override
    protected long calculateShortfall(long amount) {

        long available =
                balance + overdraftLimit;

        return Math.max(
                0,
                amount - available);
    }
}