package Practical_9.Practical_9B;

public class MiniBank {

    public static void main(String[] args)
            throws InterruptedException {

        Account account =
                new SavingsAccount(
                        "AC0001",
                        "Riya",
                        0,
                        0);

        int numberOfThreads = 10;
        int times = 100000;
        long amount = 1;

        Thread[] threads =
                new Thread[numberOfThreads];

        for (int i = 0;
             i < numberOfThreads;
             i++) {

            AccountWorker worker =
                    new AccountWorker(
                            account,
                            times,
                            amount);

            threads[i] =
                    new Thread(
                            worker,
                            "Worker-" + (i + 1));

            threads[i].start();
        }

        for (Thread thread : threads) {

            thread.join();
        }

        long expectedBalance =
                numberOfThreads
                * times
                * amount;

        System.out.println();

        System.out.println(
                "Expected Balance: "
                + expectedBalance);

        System.out.println(
                "Actual Balance: "
                + account.getBalance());
    }
}