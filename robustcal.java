import java.util.Scanner;

public class robustcal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            try {
                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = sc.next().charAt(0);

                double result = 0;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed");
                            break;
                        }
                        result = num1 / num2;
                        break;

                    default:
                        System.out.println("Invalid operator");
                        break;
                }

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    System.out.println("Result = " + result);
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers correctly.");
                sc.next();
            }

            System.out.print("Do you want to continue? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        sc.close();
    }
}
