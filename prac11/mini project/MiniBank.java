package Practical_11.Practical_11B;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MiniBank {

    public static void main(String[] args) {

        try {

            Path stateFile =
                    Paths.get("accounts.dat");

            Path logsFolder =
                    Paths.get("logs");

            Path logFile =
                    logsFolder.resolve("transactions.txt");

            Path reportFile =
                    Paths.get("end-of-day-report.txt");


            Files.createDirectories(logsFolder);


            Customer c1 =
                    new Customer(
                            "Riya",
                            "9876543210");

            Customer c2 =
                    new Customer(
                            "Aman",
                            "9123456789");

            Customer c3 =
                    new Customer(
                            "Rahul",
                            "9988776655");


            Account[] accounts = {

                new SavingsAccount(
                        "AC0001",
                        10000,
                        c1,
                        2000),

                new CurrentAccount(
                        "AC0002",
                        5000,
                        c2,
                        3000),

                new FixedDepositAccount(
                        "AC0003",
                        20000,
                        c3)
            };


            System.out.println(
                    "----- SAVING ACCOUNTS -----");

            StatePersister.save(
                    accounts,
                    stateFile);


            System.out.println();


            System.out.println(
                    "----- LOADING ACCOUNTS -----");

            Account[] loadedAccounts =
                    StatePersister.load(
                            stateFile);


            for (Account account : loadedAccounts) {

                System.out.println(account);
            }


            System.out.println();


            System.out.println(
                    "----- TRANSACTION LOG -----");


            loadedAccounts[0].deposit(500);

            TransactionLog.append(
                    logFile,
                    "DEPOSIT 500");


            if (loadedAccounts[0].withdraw(300)) {

                TransactionLog.append(
                        logFile,
                        "WITHDRAW 300");
            }


            loadedAccounts[1].deposit(1000);

            TransactionLog.append(
                    logFile,
                    "DEPOSIT 1000");


            if (loadedAccounts[1].withdraw(700)) {

                TransactionLog.append(
                        logFile,
                        "WITHDRAW 700");
            }


            System.out.println(
                    "Transactions logged");


            System.out.println();


            System.out.println(
                    "----- REPORT -----");


            ReportGenerator.generate(
                    logsFolder,
                    reportFile);


            for (String line :
                    Files.readAllLines(reportFile)) {

                System.out.println(line);
            }

        }
        catch (Exception e) {

            System.out.println(
                    "Main Error: "
                    + e.getMessage());
        }
    }
}