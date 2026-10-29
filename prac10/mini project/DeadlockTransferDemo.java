package Practical_10.Practical_10B;

public class DeadlockTransferDemo {

    public static void transfer(
            Account from,
            Account to,
            long amount) {

        synchronized (from) {

            System.out.println(
                    Thread.currentThread().getName()
                    + " locked "
                    + from.getAccountNumber());

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (to) {

                System.out.println(
                        Thread.currentThread().getName()
                        + " locked "
                        + to.getAccountNumber());

                if (from.withdraw(amount)) {

                    to.deposit(amount);
                }
            }
        }
    }

    public static void main(String[] args) {

        Account accountA =
                new Account(
                        "AC0001",
                        5000);

        Account accountB =
                new Account(
                        "AC0002",
                        5000);

        Thread t1 =
                new Thread(() -> {

                    transfer(
                            accountA,
                            accountB,
                            500);

                }, "Thread-A-to-B");


        Thread t2 =
                new Thread(() -> {

                    transfer(
                            accountB,
                            accountA,
                            300);

                }, "Thread-B-to-A");


        t1.start();
        t2.start();
    }
}