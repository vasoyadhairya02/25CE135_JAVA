package Practical_13.Practical_13B;

public class SafeVargs<T> {

    @SafeVarargs
    public final void saveAll(T... items) {
        for (T item : items) {
            save(item);
        }
    }

    private void save(T item) {
        
    }
}