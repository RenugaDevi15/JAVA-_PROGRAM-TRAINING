import java.util.Scanner;
class Student {
    private int rollNumber;
    private String name;
    private int age;
    private String grade;
    private String email;
    public Student(int rollNumber, String name, int age, String grade, String email) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
    }
    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }
    public String getEmail() { return email; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setEmail(String email) { this.email = email; }
    public void displayStudent() {
        System.out.printf("%-10d %-20s %-10d %-10s %-25s%n", 
                         rollNumber, name, age, grade, email);
    }
    
    @Override
    public String toString() {
        return "Roll No: " + rollNumber + " | Name: " + name + 
               " | Age: " + age + " | Grade: " + grade + 
               " | Email: " + email;
    }
}

// Node class for Linked List
class Node {
    Student student;
    Node next;
    
    public Node(Student student) {
        this.student = student;
        this.next = null;
    }
}

// Linked List implementation for Student Management
class StudentLinkedList {
    private Node head;
    private int size;
    
    public StudentLinkedList() {
        head = null;
        size = 0;
    }
    
    // Add student at the end
    public void addStudent(Student student) {
        Node newNode = new Node(student);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Student added successfully!");
    }
    
    // Add student at specific position
    public void addStudentAtPosition(Student student, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        
        Node newNode = new Node(student);
        
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
        System.out.println("Student added at position " + position + " successfully!");
    }
    
    // Display all students
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No students found in the system!");
            return;
        }
        
        System.out.println("\n=============================================================");
        System.out.printf("%-10s %-20s %-10s %-10s %-25s%n", 
                         "Roll No", "Name", "Age", "Grade", "Email");
        System.out.println("=============================================================");
        
        Node current = head;
        while (current != null) {
            current.student.displayStudent();
            current = current.next;
        }
        System.out.println("=============================================================");
        System.out.println("Total students: " + size);
    }
    
    // Search student by roll number
    public Student searchByRollNumber(int rollNumber) {
        Node current = head;
        int position = 1;
        
        while (current != null) {
            if (current.student.getRollNumber() == rollNumber) {
                System.out.println("\nStudent found at position " + position + ":");
                System.out.println(current.student);
                return current.student;
            }
            current = current.next;
            position++;
        }
        System.out.println("Student with roll number " + rollNumber + " not found!");
        return null;
    }
    
    // Search student by name
    public void searchByName(String name) {
        Node current = head;
        boolean found = false;
        int position = 1;
        
        System.out.println("\nSearch results for name: " + name);
        System.out.println("=============================================================");
        
        while (current != null) {
            if (current.student.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.print("Position " + position + ": ");
                System.out.println(current.student);
                found = true;
            }
            current = current.next;
            position++;
        }
        
        if (!found) {
            System.out.println("No students found with name containing: " + name);
        }
        System.out.println("=============================================================");
    }
    
    // Update student information
    public void updateStudent(int rollNumber, Scanner scanner) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            System.out.println("\n--- Update Student Information ---");
            System.out.println("Leave blank to keep current value");
            
            System.out.print("Enter new name (" + student.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.trim().isEmpty()) student.setName(name);
            
            System.out.print("Enter new age (" + student.getAge() + "): ");
            String ageInput = scanner.nextLine();
            if (!ageInput.trim().isEmpty()) student.setAge(Integer.parseInt(ageInput));
            
            System.out.print("Enter new grade (" + student.getGrade() + "): ");
            String grade = scanner.nextLine();
            if (!grade.trim().isEmpty()) student.setGrade(grade);
            
            System.out.print("Enter new email (" + student.getEmail() + "): ");
            String email = scanner.nextLine();
            if (!email.trim().isEmpty()) student.setEmail(email);
            
            System.out.println("Student information updated successfully!");
        }
    }
    
    // Delete student by roll number
    public void deleteStudent(int rollNumber) {
        if (head == null) {
            System.out.println("No students in the system!");
            return;
        }
        
        // If head node itself holds the student
        if (head.student.getRollNumber() == rollNumber) {
            head = head.next;
            size--;
            System.out.println("Student deleted successfully!");
            return;
        }
        
        // Search for the student to be deleted
        Node current = head;
        Node previous = null;
        
        while (current != null && current.student.getRollNumber() != rollNumber) {
            previous = current;
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Student with roll number " + rollNumber + " not found!");
            return;
        }
        
        previous.next = current.next;
        size--;
        System.out.println("Student deleted successfully!");
    }
    
    // Delete student by position
    public void deleteStudentAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 1) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        System.out.println("Student at position " + position + " deleted successfully!");
    }
    
    // Get total number of students
    public int getSize() {
        return size;
    }
    
    // Check if system is empty
    public boolean isEmpty() {
        return head == null;
    }
    public void sortByRollNumber() {
        if (size <= 1) return;
        for (int i = 0; i < size - 1; i++) {
            Node current = head;
            Node next = head.next;
            for (int j = 0; j < size - i - 1; j++) {
                if (current.student.getRollNumber() > next.student.getRollNumber()) {
                    // Swap student data
                    Student temp = current.student;
                    current.student = next.student;
                    next.student = temp;
                }
                current = next;
                next = next.next;
            }
        }
        System.out.println("Students sorted by roll number!");
    }
    public Student getStudentAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position!");
            return null;
        }
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        return current.student;
    }
}
public class SMSLinkedList {
    private static StudentLinkedList studentList = new StudentLinkedList();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("  STUDENT MANAGEMENT SYSTEM");
        System.out.println("  (Linked List Implementation)");
        initializeSampleData();
        while (true) {
            displayMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addStudentAtPosition();
                    break;
                case 3:
                    studentList.displayAllStudents();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 7:
                    deleteStudentAtPosition();
                    break;
                case 8:
                    studentList.sortByRollNumber();
                    break;
                case 9:
                    displayStatistics();
                    break;
                case 0:
                    System.out.println("Thank you for using Student Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    private static void displayMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add Student");
        System.out.println("2. Add Student at Specific Position");
        System.out.println("3. Display All Students");
        System.out.println("4. Search Student");
        System.out.println("5. Update Student Information");
        System.out.println("6. Delete Student by Roll Number");
        System.out.println("7. Delete Student by Position");
        System.out.println("8. Sort Students by Roll Number");
        System.out.println("9. Display Statistics");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    private static int getChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); 
            return -1;
        }
    }
    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        if (studentList.searchByRollNumber(rollNumber) != null) {
            System.out.println("Student with this roll number already exists!");
            return;
        }
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        Student student = new Student(rollNumber, name, age, grade, email);
        studentList.addStudent(student);
    }
    private static void addStudentAtPosition() {
        System.out.println("\n--- Add Student at Specific Position ---");
        System.out.print("Enter position (1 to " + (studentList.getSize() + 1) + "): ");
        int position = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        if (studentList.searchByRollNumber(rollNumber) != null) {
            System.out.println("Student with this roll number already exists!");
            return;
        }
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        Student student = new Student(rollNumber, name, age, grade, email);
        studentList.addStudentAtPosition(student, position);
    }
    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");
        System.out.println("1. Search by Roll Number");
        System.out.println("2. Search by Name");
        System.out.print("Enter choice: ");
        int choice = getChoice();
        if (choice == 1) {
            System.out.print("Enter Roll Number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            studentList.searchByRollNumber(rollNumber);
        } else if (choice == 2) {
            System.out.print("Enter Name (or part of name): ");
            String name = scanner.nextLine();
            studentList.searchByName(name);
        } else {
            System.out.println("Invalid choice!");
        }
    }
    
    private static void updateStudent() {
        System.out.println("\n--- Update Student Information ---");
        System.out.print("Enter Roll Number of student to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        studentList.updateStudent(rollNumber, scanner);
    }
    
    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.println("1. Delete by Roll Number");
        System.out.println("2. Delete by Position");
        System.out.print("Enter choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            System.out.print("Enter Roll Number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            studentList.deleteStudent(rollNumber);
        } else if (choice == 2) {
            System.out.print("Enter Position: ");
            int position = scanner.nextInt();
            scanner.nextLine();
            studentList.deleteStudentAtPosition(position);
        } else {
            System.out.println("Invalid choice!");
        }
    }
    
    private static void deleteStudentAtPosition() {
        System.out.println("\n--- Delete Student by Position ---");
        System.out.print("Enter position (1 to " + studentList.getSize() + "): ");
        int position = scanner.nextInt();
        scanner.nextLine();
        studentList.deleteStudentAtPosition(position);
    }
    
    private static void displayStatistics() {
        System.out.println("\n--- System Statistics ---");
        System.out.println("Total Students: " + studentList.getSize());
        System.out.println("Is System Empty: " + (studentList.isEmpty() ? "Yes" : "No"));
        
        if (!studentList.isEmpty()) {
            System.out.println("\nFirst Student: " + studentList.getStudentAtPosition(1));
            System.out.println("Last Student: " + studentList.getStudentAtPosition(studentList.getSize()));
        }
    }
    
    private static void initializeSampleData() {
        Student s1 = new Student(101, "John Doe", 20, "A", "john@example.com");
        Student s2 = new Student(102, "Jane Smith", 21, "B+", "jane@example.com");
        Student s3 = new Student(103, "Bob Johnson", 19, "A-", "bob@example.com");
        
        studentList.addStudent(s1);
        studentList.addStudent(s2);
        studentList.addStudent(s3);
        
        System.out.println("Sample data loaded successfully!");
    }
}