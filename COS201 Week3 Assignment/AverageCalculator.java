import java.util.InputMismatchException;
import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Average Calculator ===");

        int count = 0;
        while (count <= 0) {
            try {
                System.out.print("How many numbers do you want to enter? ");
                count = scanner.nextInt();
                if (count <= 0) {
                    System.out.println("Please enter a number greater than 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // discard bad input
            }
        }

        double sum = 0;
        int entered = 0;
        while (entered < count) {
            try {
                System.out.print("Enter number " + (entered + 1) + ": ");
                sum += scanner.nextDouble();
                entered++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // discard bad input
            }
        }

        double average = sum / count;
        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + average);

        scanner.close();
    }
}