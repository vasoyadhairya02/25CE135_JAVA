package Practical_12.Practical_12B;

import java.util.ArrayList;

public class MiniBank {

    public static void main(String[] args) {

        AccountStore store =
                new AccountStore();

        store.add(
                new SavingsAccount(
                        "AC0003",
                        "Riya",
                        15000));

        store.add(
                new CurrentAccount(
                        "AC0001",
                        "Aman",
                        5000));

        store.add(
                new SavingsAccount(
                        "AC0002",
                        "Rahul",
                        10000));


        System.out.println(
                "----- ALL ACCOUNTS -----");

        ArrayList<Account> allAccounts =
                store.getAll();

        for (Account account : allAccounts) {

            System.out.println(account);
        }


        System.out.println();


        System.out.println(
                "----- SORTED BY BALANCE -----");

        ArrayList<Account> sorted =
                store.sortedByBalance();

        for (Account account : sorted) {

            System.out.println(account);
        }


        System.out.println();


        System.out.println(
                "----- SEARCH ACCOUNT -----");

        Account found =
                store.get("AC0002");

        if (found != null) {

            System.out.println(
                    "Found: " + found);
        }
        else {

            System.out.println(
                    "Account not found");
        }


        System.out.println();


        System.out.println(
                "----- TRANSACTION HISTORY -----");

        for (String history :
                store.getTransactionHistory()) {

            System.out.println(history);
        }


        System.out.println();


        System.out.println(
                "----- CONCURRENT MAP TEST -----");

        TransactionProcessor processor =
                new TransactionProcessor();

        processor.addAccount(
                new SavingsAccount(
                        "AC1001",
                        "Priya",
                        5000));

        processor.deposit(
                "AC1001",
                2000);

        processor.withdraw(
                "AC1001",
                1000);

        System.out.println(
                processor.getAccount(
                        "AC1001"));
    }
}