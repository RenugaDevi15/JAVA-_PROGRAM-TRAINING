package Project;
import java.util.Scanner;
public class Onlinevoting{
    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Online Voting System");
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        if(age < 18){
            System.out.println("Sorry " + name + ", you are not eligible to vote.");
        }
        else{
            System.out.println("Hello " + name + ", you are eligible to vote.");
            System.out.println("Please select your candidate:");
            System.out.println("1. Candidate A");
            System.out.println("2. Candidate B");
            System.out.println("3. Candidate C");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("You voted for Candidate A");
                    break;
                case 2:
                    System.out.println("You voted for Candidate B");
                    break;
                case 3:
                    System.out.println("You voted for Candidate C");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
