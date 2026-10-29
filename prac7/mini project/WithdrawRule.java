package Practical_7;

@FunctionalInterface
public interface WithdrawRule {

    boolean allow(Account account, long amount);
}