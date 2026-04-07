import java.util.*;
public class bustickect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Bus Ticket Booking System----------");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your destination: ");
        String destination = sc.nextLine();
        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();
        double pricePerTicket = 50.0;
        double totalCost = tickets * pricePerTicket;
        System.out.println("Total cost: " + totalCost);
        System.out.println("Do you want to confirm the booking? (yes/no)");
        String confirm = sc.next();
        if (confirm.equalsIgnoreCase("yes")) {
            System.out.println("Booking confirmed for " + name + " to " + destination + " with " + tickets + " tickets.");
        } else {
            System.out.println("Booking cancelled.");
        }
    }
}

