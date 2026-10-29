package Practical_6.model;

public class FixedDepositAccount
        extends Account
        implements Premium {

    public FixedDepositAccount(String accountNumber,
                               String holderName,
                               long balance) {

        super(accountNumber, holderName, balance);
    }

    @Override
    public double interestRate() {
        return 7.0;
    }

    @Override
    public boolean canWithdraw(long amount) {
        return false;
    }
}