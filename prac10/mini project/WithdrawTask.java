package Practical_10.Practical_10B;

public class WithdrawTask implements Runnable {

    private Account account;
    private long amount;

    public WithdrawTask(Account account, long amount) {

        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {

        boolean success =
                account.withdraw(amount);

        if (success) {

            System.out.println(
                    Thread.currentThread().getName()
                    + " withdrew "
                    + amount
                    + " from "
                    + account.getAccountNumber());
        }
        else {

            System.out.println(
                    "Withdrawal failed for "
                    + account.getAccountNumber());
        }
    }
}