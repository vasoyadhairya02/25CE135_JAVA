package Practical_10.Practical_10B;

public class ProducerConsumerDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Account account =
                new Account("AC0001", 1000);

        TransactionBuffer buffer =
                new TransactionBuffer(3);

        int totalTransactions = 6;

        Thread producer =
                new Thread(() -> {

                    try {

                        buffer.add(
                                new Transaction(
                                        "DEPOSIT",
                                        account,
                                        500));

                        buffer.add(
                                new Transaction(
                                        "WITHDRAW",
                                        account,
                                        200));

                        buffer.add(
                                new Transaction(
                                        "DEPOSIT",
                                        account,
                                        300));

                        buffer.add(
                                new Transaction(
                                        "WITHDRAW",
                                        account,
                                        100));

                        buffer.add(
                                new Transaction(
                                        "DEPOSIT",
                                        account,
                                        400));

                        buffer.add(
                                new Transaction(
                                        "WITHDRAW",
                                        account,
                                        250));

                    }
                    catch (InterruptedException e) {

                        Thread.currentThread().interrupt();
                    }

                }, "Producer");


        Thread consumer =
                new Thread(() -> {

                    try {

                        for (int i = 0;
                             i < totalTransactions;
                             i++) {

                            Transaction transaction =
                                    buffer.remove();

                            if (transaction.getType()
                                    .equalsIgnoreCase("DEPOSIT")) {

                                transaction.getAccount()
                                        .deposit(
                                                transaction.getAmount());

                                System.out.println(
                                        "Consumed: Deposit "
                                        + transaction.getAmount());
                            }
                            else {

                                transaction.getAccount()
                                        .withdraw(
                                                transaction.getAmount());

                                System.out.println(
                                        "Consumed: Withdraw "
                                        + transaction.getAmount());
                            }
                        }

                    }
                    catch (InterruptedException e) {

                        Thread.currentThread().interrupt();
                    }

                }, "Consumer");


        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(
                "Final Balance: "
                + account.getBalance());
    }
}