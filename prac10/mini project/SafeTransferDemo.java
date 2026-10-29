package Practical_10.Practical_10B;

public class SafeTransferDemo {

    public static void transfer(
            Account from,
            Account to,
            long amount) {

        Account first;
        Account second;

        if (from.getAccountNumber()
                .compareTo(to.getAccountNumber()) < 0) {

            first = from;
            second = to;

        }
        else {

            first = to;
            second = from;
        }


        synchronized (first) {

            System.out.println(
                    Thread.currentThread().getName()
                    + " locked "
                    + first.getAccountNumber());

            synchronized (second) {

                System.out.println(
                        Thread.currentThread().getName()
                        + " locked "
                        + second.getAccountNumber());

                if (from.withdraw(amount)) {

                    to.deposit(amount);

                    System.out.println(
                            "Transfer successful: "
                            + from.getAccountNumber()
                            + " -> "
                            + to.getAccountNumber());
                }
                else {

                    System.out.println(
                            "Transfer failed");
                }
            }
        }
    }


    public static void main(String[] args)
            throws InterruptedException {

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

        t1.join();
        t2.join();


        System.out.println();

        System.out.println(
                "Account A Balance: "
                + accountA.getBalance());

        System.out.println(
                "Account B Balance: "
                + accountB.getBalance());

        System.out.println(
                "Completed without deadlock");
    }
}