package Practical_7;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FormValidator {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {

                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)) {

                    if (value == null ||
                            value.toString().trim().isEmpty()) {

                        errors.add(
                                field.getName() +
                                " must not be blank");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength max =
                            field.getAnnotation(MaxLength.class);

                    if (value != null &&
                            value.toString().length() > max.value()) {

                        errors.add(
                                field.getName() +
                                " maximum length is " +
                                max.value());
                    }
                }

            }
            catch (IllegalAccessException e) {

                errors.add(
                        "Cannot access field: " +
                        field.getName());
            }
        }

        return errors;
    }
}