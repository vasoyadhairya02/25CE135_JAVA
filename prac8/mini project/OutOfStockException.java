package Practical_8;

public class OutOfStockException extends Exception {

    private int shortfall;

    public OutOfStockException(String message, int shortfall) {

        super(message);

        this.shortfall = shortfall;
    }

    public int getShortfall() {

        return shortfall;
    }
}