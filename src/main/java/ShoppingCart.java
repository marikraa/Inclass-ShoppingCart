import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale locale = null;
        ArrayList<Double> prices = new ArrayList<>();

        System.out.println("You can continue the service in the following languages:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        System.out.print("\nEnter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Resource bundle not found.");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        System.out.print(rb.getString("items") + ": ");
        int items = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < items; i++) {
            System.out.print(rb.getString("price") + ": ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print(rb.getString("quantity") + ": ");
            int quantity = Integer.parseInt(scanner.nextLine());

            prices.add(calculateItem(price, quantity));
        }

        double totalCost = calculateTotal(prices);
        System.out.println(rb.getString("total") + ": " + totalCost);
    }

    public static double calculateItem(double price, int quantity) {
        return price * quantity;
    }

    public static double calculateTotal(ArrayList<Double> prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }
}