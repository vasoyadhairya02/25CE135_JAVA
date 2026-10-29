package Practical_5;

public class Driver {

    public static void main(String[] args) {

        Account[] accounts = {

            new SavingsAccount(
                    "AC0001",
                    "Darsh",
                    10000,
                    2000),

            new CurrentAccount(
                    "AC0002",
                    "Nayan",
                    5000,
                    3000),

            new FixedDepositAccount(
                    "AC0003",
                    "Ayush",
                    20000)
        };

        for (Account account : accounts) {

            System.out.println(
                    "Account Number: " +
                    account.getAccountNumber());

            System.out.println(
                    "Holder Name: " +
                    account.getHolderName());

            System.out.println(
                    "Balance: " +
                    account.getBalance());

            System.out.println(
                    "Interest Rate: " +
                    account.interestRate() + "%");

            System.out.println(
                    "Monthly Interest: " +
                    account.monthlyInterest());

            if (account instanceof SavingsAccount sa) {

                System.out.println(
                        "This is Savings Account");

                System.out.println(
                        "Minimum Balance: " +
                        sa.getMinBalance());
            }

            System.out.println("-----------------------");
        }
    }
}