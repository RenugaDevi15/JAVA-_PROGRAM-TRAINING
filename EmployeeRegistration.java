import java.util.Scanner;

public class EmployeeRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Employee Registration Form");

        System.out.print("Enter Employee ID: ");
        String empID = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        if (empID.equals("")) {
            System.out.println("Employee ID is required");
        } else if (department.equals("")) {
            System.out.println("Department is required");
        } else if (!email.contains("@")) {
            System.out.println("Invalid email format");
        } else if (phoneNumber.length() != 10) {
            System.out.println("Invalid phone number format");
        } else if (salary <= 0) {
            System.out.println("Invalid salary");
        } else {
            System.out.println("Form submitted successfully!");
            System.out.println("Employee ID: " + empID);
            System.out.println("Department: " + department);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Salary: " + salary);
        }
    }
}