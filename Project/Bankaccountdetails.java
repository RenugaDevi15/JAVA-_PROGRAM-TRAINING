 import java.util.Scanner;
 public class Bankaccountdetails{
    String name;
    int accountnumber;
    double balance;
    void createaccount(String name, int accountnumber, double balance){
        this.name = name;
        this.accountnumber = accountnumber;
        this.balance = balance;
    }
    void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
    void displaybalance(){
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
    }
    public static void main(String[] args) {
        Bankaccountdetails account = new Bankaccountdetails();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accountnumber = sc.nextInt();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        account.createaccount(name, accountnumber, balance);
        account.displaybalance();
        System.out.print("Enter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);
        account.displaybalance();
    }
}