import java.util.Scanner;
class Student {
    int rollNo;
    String name;
    String grade;
    Student next;
    Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
        this.next = null;
    }
}
public class SMSLinkedList {
    Student head = null;
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();
        Student newStudent = new Student(rollNo, name, grade);
        
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
        System.out.println("Student Added Successfully!\n");
    }
    
    public void displayStudents() {
        if (head == null) {
            System.out.println("No Students Found!\n");
            return;
        }
        
        Student temp = head;
        System.out.println("\n=== Student List ===");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + " | Name: " + temp.name + " | Grade: " + temp.grade);
            temp = temp.next;
        }
        System.out.println();
    }
    
    public void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int rollNo = sc.nextInt();
        
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found - Roll No: " + temp.rollNo + " | Name: " + temp.name + " | Grade: " + temp.grade + "\n");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student Not Found!\n");
    }
    
    public void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int rollNo = sc.nextInt();
        
        if (head == null) {
            System.out.println("No Students Found!\n");
            return;
        }
        
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student Deleted Successfully!\n");
            return;
        }
        
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("Student Not Found!\n");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student Deleted Successfully!\n");
        }
    }
    
    public void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.print("Enter New Name: ");
                temp.name = sc.nextLine();
                System.out.print("Enter New Grade: ");
                temp.grade = sc.nextLine();
                System.out.println("Student Updated Successfully!\n");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student Not Found!\n");
    }
    
    public static void main(String[] args) {
        SMSLinkedList sms = new SMSLinkedList();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: sms.addStudent(); break;
                case 2: sms.displayStudents(); break;
                case 3: sms.searchStudent(); break;
                case 4: sms.updateStudent(); break;
                case 5: sms.deleteStudent(); break;
                case 6: 
                    System.out.println("Exiting... Thank You!");
                    System.exit(0);
                default: System.out.println("Invalid Choice!\n");
            }
        }
    }
}