package Practical_12.Practical_12B;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionProcessor {

    private ConcurrentHashMap<String, Account> accounts;

    public TransactionProcessor() {

        accounts =
                new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {

        accounts.put(
                account.getAccountNumber(),
                account);
    }

    public Account getAccount(String accountNumber) {

        return accounts.get(accountNumber);
    }

    public void deposit(String accountNumber,
                        long amount) {

        Account account =
                accounts.get(accountNumber);

        if (account != null) {

            synchronized (account) {

                account.deposit(amount);
            }
        }
    }

    public boolean withdraw(String accountNumber,
                            long amount) {

        Account account =
                accounts.get(accountNumber);

        if (account != null) {

            synchronized (account) {

                return account.withdraw(amount);
            }
        }

        return false;
    }
}