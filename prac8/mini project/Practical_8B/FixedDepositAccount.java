package Practical_8.Practical_8B;

public class FixedDepositAccount extends Account {

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

    @Override
    protected long calculateShortfall(long amount) {
        return amount;
    }
}