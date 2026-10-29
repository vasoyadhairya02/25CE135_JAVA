package Practical_10.Practical_10B;

public class Transaction {

    private String type;
    private Account account;
    private long amount;

    public Transaction(String type,
                       Account account,
                       long amount) {

        this.type = type;
        this.account = account;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public Account getAccount() {
        return account;
    }

    public long getAmount() {
        return amount;
    }
}