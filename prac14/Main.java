import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Items");
            System.out.println("4. Count Items");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) {
                System.out.println("Program closed.");
                break;
            }

            try {
                if (choice == 3) {
                    service.displayItems();
                } else if (choice == 4) {
                    System.out.println("Total items: " + service.getCount());
                } else {
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    service.performAction(choice, name);
                    System.out.println("Action completed.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}