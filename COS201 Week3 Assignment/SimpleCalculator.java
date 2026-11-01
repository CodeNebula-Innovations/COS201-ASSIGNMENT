import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Simple Java Calculator ===");

        while (true) {
            try {
                System.out.print("\nEnter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char op = scanner.next().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result;
                switch (op) {
                    case '+': result = add(num1, num2); break;
                    case '-': result = subtract(num1, num2); break;
                    case '*': result = multiply(num1, num2); break;
                    case '/': result = divide(num1, num2); break;
                    default:
                        System.out.println("Invalid operator. Use +, -, * or /.");
                        continue;
                }

                System.out.println("Result: " + num1 + " " + op + " " + num2 + " = " + result);

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear bad input
            }

            System.out.print("Calculate again? (y/n): ");
            String again = scanner.next();
            if (!again.equalsIgnoreCase("y")) {
                System.out.println("Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}