import java.util.Scanner;

public class Rps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userchoice;
        int computerchoice = 2;
        System.out.println(" ======Rock Paper Scissors Game======");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissor");
        System.out.println("Enter your choice:");
        userchoice = sc.nextInt();
        System.out.println("Computer choice: " + computerchoice);
        if (userchoice == computerchoice) {
            System.out.println("Match Draw");
        } else if (userchoice == 1 && computerchoice == 3) {
            System.out.println("You Win");
        } else if (userchoice == 2 && computerchoice == 1) {
            System.out.println("You Win!");
        } else if (userchoice == 3 && computerchoice == 2) {
            System.out.println("You Win!");
        } else {
            System.out.println("Computer Wins");
        }

    }

}
