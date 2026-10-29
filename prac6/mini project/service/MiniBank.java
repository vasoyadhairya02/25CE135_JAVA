package Practical_6.service;

import Practical_6.model.Account;
import Practical_6.model.SavingsAccount;
import Practical_6.model.CurrentAccount;
import Practical_6.model.FixedDepositAccount;

import static Practical_6.util.BankUtil.printSeparator;

public class MiniBank {

    public static void main(String[] args) {

        Account[] accounts = {

            new SavingsAccount(
                    "AC0001",
                    "Riya",
                    10000,
                    2000),

            new CurrentAccount(
                    "AC0002",
                    "Aman",
                    5000,
                    3000),

            new FixedDepositAccount(
                    "AC0003",
                    "Rahul",
                    20000)
        };

        System.out.println("MINIBANK ACCOUNTS");

        printSeparator();

        for (Account account : accounts) {

            System.out.println(
                    "Account Number: "
                    + account.getAccountNumber());

            System.out.println(
                    "Holder Name: "
                    + account.getHolderName());

            System.out.println(
                    "Balance: "
                    + account.getBalance());

            System.out.println(
                    "Interest Rate: "
                    + account.interestRate()
                    + "%");

            printSeparator();
        }
    }
}