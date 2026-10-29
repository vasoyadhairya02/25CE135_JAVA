public class SignupForm {

    @NotBlank
    @MaxLength(20)
    String username;

    @NotBlank
    @MaxLength(20)
    String email;

    @NotBlank
    @MaxLength(10)
    String mobile;

    public SignupForm(String username, String email, String mobile) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
    }
}