public class Admin {
    String username = "Admin";
    String password = "password123";

    boolean login(String usernameInput, String passwordInput) {
        return username.equals(usernameInput) && password.equals(passwordInput);
    }
}
