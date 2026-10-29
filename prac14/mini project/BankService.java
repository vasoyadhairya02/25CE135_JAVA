package Practical_14.Practical_14B;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BankService {

    private Repository<Account> repository =
            new Repository<>();

    private Path logFile =
            Paths.get(
                    "logs",
                    "transactions.txt");


    public Account openAccount(String type,
                               String accountNumber,
                               String holderName,
                               long openingBalance,
                               long limit)
            throws BankException {

        if (!Validator.isValidAccountNumber(
                accountNumber)) {

            throw new BankException(
                    "Invalid account number");
        }

        if (!Validator.isValidName(holderName)) {

            throw new BankException(
                    "Invalid holder name");
        }

        if (openingBalance < 0) {

            throw new InvalidAmountException(
                    "Opening balance cannot be negative");
        }

        if (repository.findById(
                accountNumber) != null) {

            throw new BankException(
                    "Account already exists");
        }

        Account account;

        if (type.equalsIgnoreCase("SAVINGS")) {

            account =
                    new SavingsAccount(
                            accountNumber,
                            holderName,
                            openingBalance,
                            limit);
        }

        else if (type.equalsIgnoreCase("CURRENT")) {

            account =
                    new CurrentAccount(
                            accountNumber,
                            holderName,
                            openingBalance,
                            limit);
        }

        else {

            throw new BankException(
                    "Invalid account type");
        }

        repository.save(account);

        return account;
    }


    public void deposit(String accountNumber,
                        long amount)
            throws BankException {

        Account account =
                getRequiredAccount(accountNumber);

        account.deposit(amount);

        TransactionLog.append(
                logFile,
                "DEPOSIT " + amount
                + " " + accountNumber);
    }


    public void withdraw(String accountNumber,
                         long amount)
            throws BankException {

        Account account =
                getRequiredAccount(accountNumber);

        account.withdraw(amount);

        TransactionLog.append(
                logFile,
                "WITHDRAW " + amount
                + " " + accountNumber);
    }


    public void transfer(String fromId,
                         String toId,
                         long amount)
            throws BankException {

        Account from =
                getRequiredAccount(fromId);

        Account to =
                getRequiredAccount(toId);

        Account first;
        Account second;

        if (fromId.compareTo(toId) < 0) {

            first = from;
            second = to;
        }
        else {

            first = to;
            second = from;
        }

        synchronized (first) {

            synchronized (second) {

                from.withdraw(amount);

                try {

                    to.deposit(amount);

                }
                catch (InvalidAmountException e) {

                    from.deposit(amount);

                    throw e;
                }
            }
        }

        TransactionLog.append(
                logFile,
                "WITHDRAW " + amount
                + " " + fromId);

        TransactionLog.append(
                logFile,
                "DEPOSIT " + amount
                + " " + toId);
    }


    public String statement(String accountNumber)
            throws BankException {

        Account account =
                getRequiredAccount(accountNumber);

        return "----- ACCOUNT STATEMENT -----\n"
                + "Account Number: "
                + account.getAccountNumber()
                + "\nHolder: "
                + account.getHolderName()
                + "\nBalance: "
                + account.getBalance();
    }


    public ArrayList<Account> listAccounts() {

        return repository.findAll();
    }


    private Account getRequiredAccount(String id)
            throws AccountNotFoundException {

        Account account =
                repository.findById(id);

        if (account == null) {

            throw new AccountNotFoundException(
                    "Account not found: " + id);
        }

        return account;
    }


    public Repository<Account> getRepository() {

        return repository;
    }
}