import java.util.Scanner;
public class Restaurantorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        while (true) {
            System.out.println("1. Burger (150)");
            System.out.println("2. French Fries (100)");
            System.out.println("3. Pizza (200)");
            System.out.println("4. Choco Lava Cake (250)");
            System.out.println("5. Coke (50)");
            System.out.println("6. Done");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    total += 150;
                    System.out.println("Burger added");
                    break;
                case 2:
                    total += 100;
                    System.out.println("French Fries added");
                    break;
                case 3:
                    total += 200;
                    System.out.println("Pizza added");
                    break;
                case 4:
                    total += 250;
                    System.out.println("Choco Lava Cake added");
                    break;
                case 5:
                    total += 50;
                    System.out.println("Coke added");
                    break;
                case 6:
                    System.out.println("Total: " + total);
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
