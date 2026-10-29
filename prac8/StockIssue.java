import java.util.*;

class OutOfStockException extends Exception {
    private int shortfall;

    public OutOfStockException(int shortfall) {
        super("Insufficient stock. Shortfall: " + shortfall);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException() {
        super("Quantity must be greater than 0.");
    }
}

class Warehouse {

    private Map<String, Integer> stock = new HashMap<>();

    public Warehouse() {
        stock.put("Laptop", 5);
        stock.put("Mouse", 10);
        stock.put("Keyboard", 3);
    }

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException();
        }

        int available = stock.getOrDefault(item, 0);

        if (qty > available) {
            int shortfall = qty - available;
            throw new OutOfStockException(shortfall);
        }

        stock.put(item, available - qty);

        System.out.println("Issued " + qty + " " + item);
    }
}

public class StockIssue {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        String[] items = {
            "Laptop",
            "Mouse",
            "Keyboard",
            "Laptop",
            "Monitor",
            "Mouse"
        };

        int[] quantities = {
            2,
            15,
            0,
            5,
            3,
            4
        };

        for (int i = 0; i < items.length; i++) {

            try {
                warehouse.issue(items[i], quantities[i]);

            } catch (OutOfStockException e) {
                System.out.println(
                    "Failed: " + items[i] +
                    " - " + e.getMessage()
                );

            } catch (InvalidQuantityException e) {
                System.out.println(
                    "Failed: " + items[i] +
                    " - " + e.getMessage()
                );
            }
        }

        System.out.println("\nAll requests processed.");
    }
}
