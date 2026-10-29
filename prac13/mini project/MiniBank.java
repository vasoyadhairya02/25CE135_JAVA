package Practical_13.Practical_13B;

import java.util.ArrayList;

public class MiniBank {

    public static void main(String[] args) {

        Repository<Account> repository =
                new Repository<>();


        Account a1 =
                new SavingsAccount(
                        "AC0001",
                        "Riya",
                        10000,
                        2000);

        Account a2 =
                new CurrentAccount(
                        "AC0002",
                        "Aman",
                        5000,
                        3000);

        Account a3 =
                new SavingsAccount(
                        "AC0003",
                        "Rahul",
                        15000,
                        1000);


        repository.saveAll(
                a1,
                a2,
                a3);


        System.out.println(
                "----- FIND ACCOUNT -----");

        Account found =
                repository.findById(
                        "AC0002");

        System.out.println(found);


        System.out.println();


        System.out.println(
                "----- ALL ACCOUNTS -----");

        ArrayList<Account> accounts =
                repository.findAll();

        for (Account account : accounts) {

            System.out.println(account);
        }


        System.out.println();


        System.out.println(
                "----- DELETE TEST -----");

        boolean deleted =
                repository.delete(
                        "AC0003");

        System.out.println(
                "Deleted: " + deleted);


        System.out.println();


        System.out.println(
                "----- AFTER DELETE -----");

        for (Account account :
                repository.findAll()) {

            System.out.println(account);
        }


        System.out.println();


        System.out.println(
                "----- GENERIC AVERAGE -----");

        Integer[] values = {
                10,
                20,
                30,
                40
        };

        double avg =
                NumberUtil.average(values);

        System.out.println(
                "Average: " + avg);
    }
}