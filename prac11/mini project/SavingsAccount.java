package Practical_11.Practical_11B;

public class SavingsAccount extends Account {

    private static final long serialVersionUID = 1L;

    private long minBalance;

    public SavingsAccount(String accountNumber,
                          long balance,
                          Customer customer,
                          long minBalance) {

        super(accountNumber, balance, customer);

        this.minBalance = minBalance;
    }

    @Override
    public boolean canWithdraw(long amount) {

        return balance - amount >= minBalance;
    }
}