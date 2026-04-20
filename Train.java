import java.util.Scanner;

class Train {
    String passengerName;
    String source;
    String destination;
    int price;
    int numTickets;
    void bookTicket(String passengerName, String source, String destination, int price, int numTickets) {
        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.numTickets = numTickets;
        int totalPrice = calculatePrice(price, numTickets);
        System.out.println("Ticket booked for " + passengerName + " from " + source + " to " + destination + " for $" + totalPrice);
    }
    int calculatePrice(int price, int numTickets) {
        // Apply discount for bulk booking
        if (numTickets >= 5) {
            return (price * numTickets) * 9 / 10; // 10% discount
        } else if (numTickets >= 2) {
            return (price * numTickets) * 95 / 100; // 5% discount
        } else {
            return price * numTickets;
        }
    }
    void getTicketDetails() {
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Number of Tickets: " + numTickets);
        System.out.println("Price per Ticket: $" + price);
        System.out.println("Total Price: $" + calculatePrice(price, numTickets));
    }
    public static void main(String[] args) {
        Train train = new Train();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();
        System.out.print("Enter source: ");
        String source = sc.nextLine();
        System.out.print("Enter destination: ");
        String destination = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        System.out.print("Enter number of tickets: ");
        int numTickets = sc.nextInt();
        train.bookTicket(name, source, destination, price, numTickets);
        train.getTicketDetails();
    }
}