public class Driver
{

    public static void main(String[] args)
    {
        String[] passwords =
        {
            "shyam",
            "shyam123",
            "Shyam123", 
            "Shyam@123"
        };

        for (String pw : passwords)
        {
            System.out.println("Password: " + pw);

            System.out.println("Length >= 8: " + PasswordChecker.lengthCheck(pw));

            System.out.println("Contains uppercase: " + PasswordChecker.uppercaseCheck(pw));

            System.out.println("Contains digit: " + PasswordChecker.digitCheck(pw));

            System.out.println("Contains special character: " + PasswordChecker.specialCheck(pw));

            System.out.println("Strength: " + PasswordChecker.strength(pw));

            System.out.println("-----------------------------");
        }
    
    }


}
