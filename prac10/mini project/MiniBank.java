package Practical_10.Practical_10B;

public class MiniBank {

    public static void main(String[] args) {

        Account account =
                new Account(
                        "AC0001",
                        1000);

        TransactionProcessor processor =
                new TransactionProcessor();

        processor.submit(
                new DepositTask(
                        account,
                        500));

        processor.submit(
                new WithdrawTask(
                        account,
                        200));

        processor.submit(
                new DepositTask(
                        account,
                        300));

        processor.submit(
                new WithdrawTask(
                        account,
                        100));

        processor.submit(
                new DepositTask(
                        account,
                        1000));

        processor.submit(
                new WithdrawTask(
                        account,
                        250));

        processor.stop();

        System.out.println();

        System.out.println(
                "Final Balance: "
                + account.getBalance());
    }
}