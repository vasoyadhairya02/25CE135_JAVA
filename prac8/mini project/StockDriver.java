package Practical_8;

public class StockDriver {

    public static void main(String[] args) {

        WareHouse warehouse =
                new WareHouse("Laptop", 10);

        String[] items = {
                "Laptop",
                "Laptop",
                "Laptop",
                "Laptop"
        };

        int[] quantities = {
                3,
                15,
                -2,
                4
        };

        for (int i = 0; i < items.length; i++) {

            try {

                System.out.println(
                        "Request: "
                        + items[i]
                        + " Qty: "
                        + quantities[i]);

                warehouse.issue(
                        items[i],
                        quantities[i]);
            }

            catch (OutOfStockException e) {

                System.out.println(
                        "Out of stock: "
                        + e.getMessage());

                System.out.println(
                        "Shortfall: "
                        + e.getShortfall());
            }

            catch (InvalidQuantityException e) {

                System.out.println(
                        "Invalid quantity: "
                        + e.getMessage());
            }

            System.out.println("--------------------");
        }

        System.out.println(
                "All requests processed.");
    }
}