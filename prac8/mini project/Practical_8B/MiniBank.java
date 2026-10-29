package Practical_8.Practical_8B;

public class MiniBank {

    public static void main(String[] args) {

        Account savings =
                new SavingsAccount(
                        "AC0001",
                        "Riya",
                        10000,
                        2000);

        Account current =
                new CurrentAccount(
                        "AC0002",
                        "Aman",
                        5000,
                        3000);


        System.out.println("----- DEPOSIT TEST -----");

        try {

            savings.deposit(-500);

        }
        catch (InvalidAmountException e) {

            System.out.println(
                    "Deposit Error: "
                    + e.getMessage());
        }
        finally {

            System.out.println(
                    "Deposit attempt completed");
        }


        System.out.println();


        System.out.println("----- WITHDRAW TEST -----");

        try {

            savings.withdraw(9000);

            System.out.println(
                    "Withdrawal successful");

        }
        catch (InsufficientFundsException e) {

            System.out.println(
                    "Withdrawal Error: "
                    + e.getMessage());

            System.out.println(
                    "Shortfall: "
                    + e.getShortfall());
        }
        catch (InvalidAmountException e) {

            System.out.println(
                    "Invalid Amount: "
                    + e.getMessage());
        }
        finally {

            System.out.println(
                    "Withdrawal attempt completed");
        }


        System.out.println();


        System.out.println("----- TRANSFER TEST -----");

        try {

            savings.transfer(
                    current,
                    3000);

            System.out.println(
                    "Savings Balance: "
                    + savings.getBalance());

            System.out.println(
                    "Current Balance: "
                    + current.getBalance());
        }

        catch (BankException e) {

            System.out.println(
                    "Bank Error: "
                    + e.getMessage());
        }


        System.out.println();


        System.out.println(
                "----- TRY-WITH-RESOURCES -----");

        try (BankResource resource =
                     new BankResource()) {

            resource.use();

            System.out.println(
                    "Operation inside resource");

        }
        catch (Exception e) {

            System.out.println(
                    "Resource Error: "
                    + e.getMessage());
        }
    }
}