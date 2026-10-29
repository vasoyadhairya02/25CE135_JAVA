package Practical_13.Practical_13B;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Repository<T> {

    private HashMap<String, T> data =
            new HashMap<>();


    public T save(T entity) {

        String id = getId(entity);

        data.put(id, entity);

        return entity;
    }


    public T findById(String id) {

        return data.get(id);
    }


    public ArrayList<T> findAll() {

        return new ArrayList<>(data.values());
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


    private String getId(T entity) {

        Class<?> currentClass =
                entity.getClass();

        while (currentClass != null) {

            Field[] fields =
                    currentClass.getDeclaredFields();

            for (Field field : fields) {

                if (field.isAnnotationPresent(Id.class)) {

                    try {

                        field.setAccessible(true);

                        Object value =
                                field.get(entity);

                        if (value == null) {

                            throw new IllegalArgumentException(
                                    "Id cannot be null");
                        }

                        return value.toString();

                    }
                    catch (IllegalAccessException e) {

                        throw new RuntimeException(
                                "Cannot access Id field");
                    }
                }
            }

            currentClass =
                    currentClass.getSuperclass();
        }

        throw new IllegalArgumentException(
                "No field marked with @Id found");
    }
}