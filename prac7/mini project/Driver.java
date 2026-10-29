package Practical_7;

import java.util.List;

public class Driver {

    public static void main(String[] args) {

        SignupForm form =
                new SignupForm(
                        "",
                        "verylongemailaddress@example.com",
                        "Vadodara");

        List<String> errors =
                FormValidator.validate(form);

        System.out.println("Validation Errors:");

        for (String error : errors) {

            System.out.println(error);
        }
    }
}
