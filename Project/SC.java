import java.util.Scanner;
public class SC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Simple Calcultaor----------");
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number:");
        int b = sc.nextInt();
        System.out.println("Enter operator (+, -, *, /):");
switch (sc.next()){
    case "+":
        System.out.println(a+b);
        break;
    case "-":
         System.out.println(a -b);
            break;  
    case "*":
         System.out.println(a * b);
            break;
    case "/":
            if(b != 0){
                System.out.println(a / b);
            }
            else{
                System.out.println("Cannot divide by zero");
            }
                break;
    default:
        System.out.println("Invalid operator");
        }  

    }
}

