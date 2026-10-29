package Practical_7;

import java.lang.reflect.Field;

public class ColumnMapper {

    public static void populate(
            Object obj,
            String[] headers,
            String[] data) {

        Field[] fields =
                obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Column.class)) {

                Column column =
                        field.getAnnotation(Column.class);

                String columnName =
                        column.name();

                int index = -1;

                for (int i = 0; i < headers.length; i++) {

                    if (headers[i].equals(columnName)) {

                        index = i;
                        break;
                    }
                }

                if (index != -1 &&
                        index < data.length) {

                    field.setAccessible(true);

                    try {

                        field.set(
                                obj,
                                data[index]);

                    }
                    catch (IllegalAccessException e) {

                        System.out.println(
                                "Cannot set field");
                    }
                }
                else {

                    System.out.println(
                            "Missing column: " +
                            columnName);
                }
            }
        }
    }
}
