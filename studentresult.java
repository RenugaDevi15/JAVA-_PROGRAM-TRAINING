import java.util.Scanner;
public class studentresult {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter marks for Subject 1: ");
            int subject1 = sc.nextInt();
            System.out.print("Enter marks for Subject 2: ");
            int subject2 = sc.nextInt();
            System.out.print("Enter marks for Subject 3: ");
            int subject3 = sc.nextInt();
            int total = subject1 + subject2 + subject3;
            double percentage = total / 3.0;
            System.out.println("Total Marks: " + total);
            System.out.println("Percentage: " + percentage + "%");
            if (percentage >= 90) {
                System.out.println("Grade: A");
            } else if (percentage >= 80) {
                System.out.println("Grade: B");
            } else if (percentage >= 70) {
                System.out.println("Grade: C");
            } else if (percentage >= 60) {
                System.out.println("Grade: D");
            } else {
                System.out.println("Grade: F");
            }
        }
    }
}