import java.util.*;

public class ATM {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int balance = 10000;
            int pin = 1234;

            System.out.println("Enter ATM Pin:");
            int enteredpin = sc.nextInt();

            if (enteredpin == pin) {

                int choice;

                while (true) {

                    System.out.println("\n---- ATM MENU ----");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");
                    System.out.println("Enter your choice:");

                    choice = sc.nextInt();

                    switch (choice) {

                        case 1 :
                         System.out.println("Balance: " + balance);

                        case 2: {
                            System.out.println("Enter deposit amount:");
                            int deposit = sc.nextInt();
                            balance = balance + deposit;
                            System.out.println("Updated Balance: " + balance);
                        }

                        case 3 :{
                            System.out.println("Enter withdraw amount:");
                            int withdraw = sc.nextInt();

                            if (withdraw <= balance) {
                                balance = balance - withdraw;
                                System.out.println("Updated Balance: " + balance);
                            } else {
                                System.out.println("Insufficient Balance");
                            }
                        }

                        case 4 : {
                            System.out.println("Thank you for using ATM!");
                            return;
                        }

                        default:
                         System.out.println("Invalid Choice");
                    }
                }

            } else {
                System.out.println("Incorrect PIN");
            }

            sc.close();
        }
    }
}