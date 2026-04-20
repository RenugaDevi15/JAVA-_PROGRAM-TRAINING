package Project;
import java.util.Scanner;
public class Passwordloginsystem {
    public static void main(String[] args) {
        int attempts = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------Welcome to the Login System----------");
        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (username.equals("admin") && password.equals("password123")) {
                System.out.println("Login successful!");
                return;
            } else {
                attempts--;
                System.out.println("Invalid username or password. Attempts remaining: " + attempts);
            }
        }
        System.out.println("Maximum attempts reached. Login failed.");
    }
}