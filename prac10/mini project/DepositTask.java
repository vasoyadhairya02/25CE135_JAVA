package Practical_10.Practical_10B;

public class DepositTask implements Runnable {

    private Account account;
    private long amount;

    public DepositTask(Account account, long amount) {

        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {

        account.deposit(amount);

        System.out.println(
                Thread.currentThread().getName()
                + " deposited "
                + amount
                + " into "
                + account.getAccountNumber());
    }
}