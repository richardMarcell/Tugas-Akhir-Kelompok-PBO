public class Admin {
    // Atribut kelas Admin
    String username = "Admin";
    String password = "password123";

    // Metode Login
    boolean login(String usernameInput, String passwordInput) {
        // Equals digunakan untuk membandingkan nilai dari variabel username dan usernameInput apakah sama atau tidak, jika sama nilainya "true"
        return username.equals(usernameInput) && password.equals(passwordInput);
    }
}
