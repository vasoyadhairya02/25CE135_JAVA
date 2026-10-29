package Practical_7;

public class SampleTests {

    @Run
    public void testDeposit() {

        System.out.println(
                "Deposit test executed");
    }

    @Run
    public void testWithdraw() {

        System.out.println(
                "Withdraw test executed");
    }

    public void normalMethod() {

        System.out.println(
                "This should not run");
    }

    @Run
    public void testBalance() {

        System.out.println(
                "Balance test executed");
    }
}
