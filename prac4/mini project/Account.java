public class Account {

    private String accountNumber;
    private String holderName;
    private long balance;

    public Account(String accountNumber, String holderName, long balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public void withdraw(long amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }
    }
}