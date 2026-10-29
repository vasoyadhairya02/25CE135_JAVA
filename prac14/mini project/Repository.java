package Practical_14.Practical_14B;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Repository<T> {

    private ConcurrentHashMap<String, T> data =
            new ConcurrentHashMap<>();

    public T save(T entity) {

        String id = findId(entity);

        data.put(id, entity);

        return entity;
    }

    public T findById(String id) {

        return data.get(id);
    }

    public ArrayList<T> findAll() {

        return new ArrayList<>(
                data.values());
    }

    public boolean delete(String id) {

        return data.remove(id) != null;
    }

    @SafeVarargs
    public final void saveAll(T... items) {

        for (T item : items) {
            save(item);
        }
    }

    private String findId(T entity) {

        Class<?> current =
                entity.getClass();

        while (current != null) {

            for (Field field :
                    current.getDeclaredFields()) {

                if (field.isAnnotationPresent(Id.class)) {

                    try {

                        field.setAccessible(true);

                        Object value =
                                field.get(entity);

                        return value.toString();

                    }
                    catch (IllegalAccessException e) {

                        throw new RuntimeException(
                                "Cannot access @Id field");
                    }
                }
            }

            current = current.getSuperclass();
        }

        throw new IllegalArgumentException(
                "No @Id field found");
    }
}