package Practical_11.Practical_11B;

public class CurrentAccount extends Account {

    private static final long serialVersionUID = 1L;

    private long overdraftLimit;

    public CurrentAccount(String accountNumber,
                          long balance,
                          Customer customer,
                          long overdraftLimit) {

        super(accountNumber, balance, customer);

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean canWithdraw(long amount) {

        return balance - amount >= -overdraftLimit;
    }
}