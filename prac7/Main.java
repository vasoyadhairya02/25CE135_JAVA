import java.util.List;

public class Main {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
                "",
                "shyamkapuriya@example.com",
                "123456789009876543210"
        );

        List<String> errors = FormValidator.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}