package Practical_14.Practical_14B;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern ACCOUNT_PATTERN =
            Pattern.compile("^AC[0-9]{4}$");

    public static boolean isValidAccountNumber(String accountNumber) {

        return accountNumber != null
                && ACCOUNT_PATTERN.matcher(accountNumber).matches();
    }

    public static boolean isValidAmount(long amount) {

        return amount > 0;
    }

    public static boolean isValidName(String name) {

        return name != null
                && !name.trim().isEmpty();
    }
}