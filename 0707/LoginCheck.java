public class LoginCheck {
    public static void main(String[] args) {
        String username = "admin";
        String password = "password123";
        boolean isAuthenticated = username.equals("admin") && password.equals("password123");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Is Authenticated: " + isAuthenticated);
    }
}
