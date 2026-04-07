import java.util.Scanner;
public class Hospitalmanagement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter patient name: ");
        String name = sc.nextLine();
        System.out.print("Enter patient age: ");
        int age = sc.nextInt();
        System.out.println("Add Patient Details:");
        System.out.println("1. Add Medical History");
        System.out.println("2. Add Current Medications");
        System.out.println("3. Add Allergies");
        int choice = sc.nextInt();
        String medicalHistory = "";
        String currentMedications = "";
        String allergies = "";
        System.out.println("View Patient Details:");
        System.out.println("1. View Medical History");
        System.out.println("2. View Current Medications");
        System.out.println("3. View Allergies");
        int viewChoice = sc.nextInt();
        String viewmedicalhistory = "";
        String viewcurrentmedications = "";
        String viewallergies = "";
        System.out.println("Search Patient Records:");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Age");
        int searchChoice = sc.nextInt();
        String searchname = "";
        int searchage = 0;
        System.out.println("Delete Patient Records:");
        System.out.println("1. Delete by Name");
        System.out.println("2. Delete by Age");
        int deleteChoice = sc.nextInt();
        String deletename = "";
        int deleteage = 0;
        switch(choice){
            case 1:
            System.out.println("Add Medication History: " + medicalHistory);
            break;
            case 2:
            System.out.println("Add Current Medications: " + currentMedications);
            break;
            case 3:
            System.out.println("Add Allergies: " + allergies);
            break;
            default:
            System.out.println("Invalid choice.");
        }
        switch (viewChoice){
            case 1:
            System.out.println("View Medical History: " + viewmedicalhistory);
            break;
            case 2:
            System.out.println("View Current Medications: " + viewcurrentmedications);
            break;
            case 3:
            System.out.println("View Allergies: " + viewallergies);
            break;
            default:
            System.out.println("Invalid choice,"); 
        }
        switch(searchChoice){
            case 1:
            System.out.println("Search by name: " + searchname);
            break;
            case 2:
            System.out.println("Search by age: " + searchage);
            break;
            default:
            System.out.println("Invalid choice.");
            }
            switch(deleteChoice){
                case 1:
                System.out.println("Delete by name: " + deletename);
                break;
                case 2:
                System.out.println("Delete by age: " + deleteage);
                break;
                default:
                System.out.println("Invalid choice.");
            }
    }
}
