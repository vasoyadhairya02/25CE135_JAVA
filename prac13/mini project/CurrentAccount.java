package Practical_13.Practical_13B;

public class CurrentAccount extends Account {

    private long overdraftLimit;

    public CurrentAccount(String accountNumber,
                          String holderName,
                          long balance,
                          long overdraftLimit) {

        super(accountNumber, holderName, balance);

        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}