public class Item {
    private String name;

    public Item(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}