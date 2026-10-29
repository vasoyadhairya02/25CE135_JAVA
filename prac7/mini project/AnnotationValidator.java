package Practical_7;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationValidator {

    public static String[] validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Class<?> currentClass = obj.getClass();

        while (currentClass != null) {

            Field[] fields =
                    currentClass.getDeclaredFields();

            for (Field field : fields) {

                field.setAccessible(true);

                try {

                    Object value = field.get(obj);

                    // Check @Positive
                    if (field.isAnnotationPresent(Positive.class)) {

                        Positive positive =
                                field.getAnnotation(Positive.class);

                        if (value instanceof Number) {

                            Number number =
                                    (Number) value;

                            if (number.longValue() <= 0) {

                                errors.add(
                                        field.getName()
                                        + " "
                                        + positive.message());
                            }
                        }
                    }

                    // Check @MaxLength
                    if (field.isAnnotationPresent(MaxLength.class)) {

                        MaxLength maxLength =
                                field.getAnnotation(MaxLength.class);

                        if (value != null
                                && value.toString().length()
                                > maxLength.value()) {

                            errors.add(
                                    field.getName()
                                    + " length must be <= "
                                    + maxLength.value());
                        }
                    }

                }
                catch (IllegalAccessException e) {

                    errors.add(
                            "Cannot access field: "
                            + field.getName());
                }
            }

            currentClass =
                    currentClass.getSuperclass();
        }

        return errors.toArray(new String[0]);
    }
}