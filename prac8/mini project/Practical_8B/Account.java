package Practical_8.Practical_8B;

public abstract class Account {

    protected String accountNumber;
    protected String holderName;
    protected long balance;

    public Account(String accountNumber,
                   String holderName,
                   long balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than 0");
        }

        balance = balance + amount;
    }

    public void withdraw(long amount)
            throws InsufficientFundsException,
                   InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than 0");
        }

        if (!canWithdraw(amount)) {

            long shortfall = calculateShortfall(amount);

            throw new InsufficientFundsException(
                    "Insufficient funds",
                    shortfall);
        }

        balance = balance - amount;
    }

    protected long calculateShortfall(long amount) {

        if (amount > balance) {
            return amount - balance;
        }

        return 0;
    }

    public void transfer(Account to, long amount)
            throws BankException {

        try {

            if (to == null) {
                throw new AccountNotFoundException(
                        "Target account not found");
            }

            withdraw(amount);

            to.deposit(amount);

            System.out.println("Transfer successful");
        }

        catch (BankException e) {

            System.out.println(
                    "Transfer failed: " + e.getMessage());

            throw e;
        }

        finally {

            System.out.println(
                    "Transfer attempt completed");
        }
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);
}