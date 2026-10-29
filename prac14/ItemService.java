import java.util.ArrayList;

public class ItemService {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String name) {
        items.add(new Item(name));
    }

    public void removeItem(String name) {
        boolean removed = items.removeIf(
            item -> item.getName().equals(name)
        );

        if (!removed) {
            throw new IllegalArgumentException("Item not found");
        }
    }

    public int getCount() {
        return items.size();
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        for (Item item : items) {
            System.out.println(item.getName());
        }
    }

    public void performAction(int action, String name) {
        switch (action) {
            case 1:
                addItem(name);
                break;
            case 2:
                removeItem(name);
                break;
            default:
                throw new IllegalArgumentException("Invalid action");
        }
    }
}