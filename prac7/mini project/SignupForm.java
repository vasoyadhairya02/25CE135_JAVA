package Practical_7;

public class SignupForm {

    @NotBlank
    @MaxLength(20)
    private String username;

    @NotBlank
    @MaxLength(30)
    private String email;

    @MaxLength(10)
    private String city;

    public SignupForm(String username, String email, String city) {

        this.username = username;
        this.email = email;
        this.city = city;
    }
}