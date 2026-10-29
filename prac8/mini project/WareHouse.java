package Practical_8;

public class WareHouse {

    private String item;
    private int stock;

    public WareHouse(String item, int stock) {

        this.item = item;
        this.stock = stock;
    }

    public void issue(String requestedItem, int qty)
            throws OutOfStockException,
                   InvalidQuantityException {

        if (qty <= 0) {

            throw new InvalidQuantityException(
                    "Quantity must be greater than 0");
        }

        if (!requestedItem.equalsIgnoreCase(item)) {

            System.out.println(
                    "Item not found: " + requestedItem);

            return;
        }

        if (qty > stock) {

            int shortfall = qty - stock;

            throw new OutOfStockException(
                    "Not enough stock available",
                    shortfall);
        }

        stock = stock - qty;

        System.out.println(
                qty + " " + item + " issued successfully");

        System.out.println(
                "Remaining stock: " + stock);
    }
}