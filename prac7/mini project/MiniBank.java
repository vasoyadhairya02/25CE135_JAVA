package Practical_7;

public class MiniBank {

    public static void main(String[] args) {

        Account account =
                new SavingsAccount(
                        "AC0001",
                        "Riya",
                        -500,
                        1000);

        String[] errors =
                AnnotationValidator.validate(account);

        System.out.println("Validation Errors:");

        for (String error : errors) {

            System.out.println(error);
        }
    }
}