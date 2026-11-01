import java.util.InputMismatchException;
import java.util.Scanner;

public class TotalCost {

    static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                if (value < 0) {
                    System.out.println("Value cannot be negative.");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // discard bad input
            }
        }
    }

    static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                if (value <= 0) {
                    System.out.println("Quantity must be at least 1.");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // discard bad input
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Total Cost Calculator ===");

        double grandTotal = 0;
        int itemNumber = 1;
        String another;

        do {
            System.out.println("\n--- Item " + itemNumber + " ---");
            scanner.nextLine(); // consume leftover newline
            System.out.print("Item name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = "Item " + itemNumber;
            }

            int quantity = readPositiveInt(scanner, "Quantity: ");
            double price = readPositiveDouble(scanner, "Price per unit: ");

            double itemTotal = quantity * price;
            grandTotal += itemTotal;

            System.out.printf("%s: %d x %.2f = %.2f%n", name, quantity, price, itemTotal);

            System.out.print("Add another item? (y/n): ");
            another = scanner.next();
            itemNumber++;
        } while (another.equalsIgnoreCase("y"));

        System.out.printf("%n=== Total cost: %.2f ===%n", grandTotal);

        scanner.close();
    }
}