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
                String name = field.getName();

                if (field.isAnnotationPresent(NotBlank.class)) {

                    if (value == null || value.toString().trim().isEmpty()) {
                        errors.add(name + " must not be blank");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength maxLength =
                            field.getAnnotation(MaxLength.class);

                    if (value != null &&
                        value.toString().length() > maxLength.value()) {

                        errors.add(name + " must not exceed "
                                + maxLength.value() + " characters");
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add("Cannot access " + field.getName());
            }
        }

        return errors;
    }
}