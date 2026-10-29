import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemServiceTest {

    @Test
    void addingItemIncreasesCount() {
        ItemService service = new ItemService();

        service.addItem("Pen");

        assertEquals(1, service.getCount());
    }

    @Test
    void invalidActionThrowsException() {
        ItemService service = new ItemService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.performAction(99, "Pen");
        });
    }

    @Test
    void removingItemDecreasesCount() {
        ItemService service = new ItemService();
        service.addItem("Book");

        service.removeItem("Book");

        assertEquals(0, service.getCount());
    }
}