package Practical_14.Practical_14B;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        BankService service =
                new BankService();

        Path stateFile =
                Paths.get("accounts.dat");

        Path logsFolder =
                Paths.get("logs");

        Path reportFile =
                Paths.get("bank-report.txt");


        // Load saved accounts
        Account[] saved =
                StatePersister.load(stateFile);

        service.getRepository()
                .saveAll(saved);


        int choice;

        do {

            System.out.println();
            System.out.println(
                    "===== MINIBANK =====");

            System.out.println(
                    "1. Open Account");

            System.out.println(
                    "2. Deposit");

            System.out.println(
                    "3. Withdraw");

            System.out.println(
                    "4. Transfer");

            System.out.println(
                    "5. Statement");

            System.out.println(
                    "6. List Accounts");

            System.out.println(
                    "7. Batch Deposits");

            System.out.println(
                    "8. Generate Report");

            System.out.println(
                    "9. Exit");

            System.out.print(
                    "Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1 -> {

                        System.out.print(
                                "Type SAVINGS/CURRENT: ");

                        String type =
                                sc.nextLine();

                        System.out.print(
                                "Account Number: ");

                        String number =
                                sc.nextLine();

                        System.out.print(
                                "Holder Name: ");

                        String name =
                                sc.nextLine();

                        System.out.print(
                                "Opening Balance: ");

                        long balance =
                                sc.nextLong();

                        System.out.print(
                                "Minimum Balance / Overdraft Limit: ");

                        long limit =
                                sc.nextLong();

                        service.openAccount(
                                type,
                                number,
                                name,
                                balance,
                                limit);

                        System.out.println(
                                "Account opened");
                    }


                    case 2 -> {

                        System.out.print(
                                "Account Number: ");

                        String number =
                                sc.nextLine();

                        System.out.print(
                                "Amount: ");

                        long amount =
                                sc.nextLong();

                        service.deposit(
                                number,
                                amount);

                        System.out.println(
                                "Deposit successful");
                    }


                    case 3 -> {

                        System.out.print(
                                "Account Number: ");

                        String number =
                                sc.nextLine();

                        System.out.print(
                                "Amount: ");

                        long amount =
                                sc.nextLong();

                        service.withdraw(
                                number,
                                amount);

                        System.out.println(
                                "Withdrawal successful");
                    }


                    case 4 -> {

                        System.out.print(
                                "From Account: ");

                        String from =
                                sc.nextLine();

                        System.out.print(
                                "To Account: ");

                        String to =
                                sc.nextLine();

                        System.out.print(
                                "Amount: ");

                        long amount =
                                sc.nextLong();

                        service.transfer(
                                from,
                                to,
                                amount);

                        System.out.println(
                                "Transfer successful");
                    }


                    case 5 -> {

                        System.out.print(
                                "Account Number: ");

                        String number =
                                sc.nextLine();

                        System.out.println(
                                service.statement(
                                        number));
                    }


                    case 6 -> {

                        for (Account account :
                                service.listAccounts()) {

                            System.out.println(
                                    account);
                        }
                    }


                    case 7 -> {

                        System.out.print(
                                "Account Number: ");

                        String number =
                                sc.nextLine();

                        TransactionProcessor processor =
                                new TransactionProcessor();

                        for (int i = 0; i < 100; i++) {

                            processor.submit(() -> {

                                try {

                                    service.deposit(
                                            number,
                                            10);

                                }
                                catch (BankException e) {

                                    System.out.println(
                                            e.getMessage());
                                }
                            });
                        }

                        processor.stop();

                        System.out.println(
                                "Batch completed");
                    }


                    case 8 -> {

                        ReportGenerator.generate(
                                logsFolder,
                                reportFile);

                        System.out.println(
                                "----- REPORT -----");

                        if (Files.exists(reportFile)) {

                            for (String line :
                                    Files.readAllLines(
                                            reportFile)) {

                                System.out.println(line);
                            }
                        }
                    }


                    case 9 -> {

                        Account[] accounts =
                                service.listAccounts()
                                        .toArray(
                                                new Account[0]);

                        StatePersister.save(
                                accounts,
                                stateFile);

                        System.out.println(
                                "Accounts saved.");

                        System.out.println(
                                "MiniBank closed.");
                    }


                    default ->
                            System.out.println(
                                    "Invalid choice");
                }

            }
            catch (BankException e) {

                System.out.println(
                        "Bank Error: "
                        + e.getMessage());

                if (e instanceof
                        InsufficientFundsException ex) {

                    System.out.println(
                            "Shortfall: "
                            + ex.getShortfall());
                }
            }

            catch (Exception e) {

                System.out.println(
                        "Error: "
                        + e.getMessage());
            }

        } while (choice != 9);

        sc.close();
    }
}