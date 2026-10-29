package Practical_14.Practical_14B;

import Practical_14.Test;

public class BankServiceTest {

    @Test
    public void depositIncreasesBalance()
            throws Exception {

        BankService service =
                new BankService();

        Account account =
                service.openAccount(
                        "SAVINGS",
                        "AC0001",
                        "Riya",
                        1000,
                        0);

        service.deposit(
                "AC0001",
                500);

        assertEquals(
                1500,
                account.getBalance());
    }


    private void assertEquals(int i, long balance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
}


    @Test
    public void withdrawalOverLimitThrows()
            throws Exception {

        BankService service =
                new BankService();

        service.openAccount(
                "SAVINGS",
                "AC0002",
                "Aman",
                1000,
                500);

        assertThrows(
                InsufficientFundsException.class,
                () -> service.withdraw(
                        "AC0002",
                        800));
    }


    @Test
    public void concurrentDepositsRemainCorrect()
            throws Exception {

        BankService service =
                new BankService();

        Account account =
                service.openAccount(
                        "SAVINGS",
                        "AC0003",
                        "Rahul",
                        0,
                        0);

        TransactionProcessor processor =
                new TransactionProcessor();

        for (int i = 0; i < 1000; i++) {

            processor.submit(() -> {

                try {

                    service.deposit(
                            "AC0003",
                            1);

                }
                catch (BankException e) {

                    fail(
                            e.getMessage());
                }
            });
        }

        processor.stop();

        assertEquals(
                1000,
                account.getBalance());
    }
}