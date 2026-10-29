package Practical_14.Practical_14B;

public class InsufficientFundsException extends BankException {

    private long shortfall;

    public InsufficientFundsException(String message,
                                      long shortfall) {

        super(message);
        this.shortfall = shortfall;
    }

    public long getShortfall() {
        return shortfall;
    }
}