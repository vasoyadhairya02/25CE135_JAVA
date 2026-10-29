package Practical_11.Practical_11B;

public class FixedDepositAccount extends Account {

    private static final long serialVersionUID = 1L;

    public FixedDepositAccount(String accountNumber,
                               long balance,
                               Customer customer) {

        super(accountNumber, balance, customer);
    }

    @Override
    public boolean canWithdraw(long amount) {

        return false;
    }
}